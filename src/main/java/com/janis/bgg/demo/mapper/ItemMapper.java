package com.janis.bgg.demo.mapper;

import com.google.common.collect.Sets;
import com.janis.bgg.demo.entity.Designer;
import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.entity.Mechanic;
import com.janis.bgg.demo.entity.Recomendation;
import com.janis.bgg.demo.xml.Items3.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {

    @Mapping(target = "recomendations", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "yearPublished", source = "yearpublished.value")
    @Mapping(target = "rank", ignore = true)
    @Mapping(target = "playingTime", ignore = true)
    @Mapping(target = "minPlayers", source = "minplayers.value")
    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "maxPlayers", source = "maxplayers.value")
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "bggRating", source = "statistics.ratings.bayesaverage.value")
    @Mapping(target = "averageRating", source = "statistics.ratings.average.value")
    @Mapping(target = "name", ignore = true)
    public abstract GraDescription itemToGraMapper(Item item);

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }

    @AfterMapping
    protected void nameMapper(Item item, @MappingTarget GraDescription gra) {
        String name = item.getName().stream().filter(t -> t.getType().equals("primary")).collect(Collectors.toList()).get(0).getValue();
        gra.setName(name);
        Set<Mechanic> mechanicsSet = Sets.newHashSet();
        Set<Designer> designersSet = Sets.newHashSet();
        Set<Recomendation> recommendationsSet = Sets.newHashSet();
        item.getLink().stream().filter(t -> t.getType().equals("boardgamemechanic")).map(m -> m.getValue()).forEach(mechanic -> mechanicsSet.add(new Mechanic(mechanic)));
        gra.setMechanics(mechanicsSet);
        item.getLink().stream().filter(t -> t.getType().equals("boardgamedesigner")).map(m -> m.getValue()).forEach(designer -> designersSet.add(new Designer(designer)));
        gra.setDesigners(designersSet);
        gra.setPlayingTime(item.getMaxplaytimeOrMinageOrMinplaytime().stream().filter(t -> t instanceof Playingtime).map(p -> ((Playingtime) p).getValue()).collect(toSingleton()));
        gra.setRank(item.getStatistics().getRatings().getRanks().getRank().stream().filter(r -> r.getFriendlyname().equals("Board Game Rank")).map(Rank::getBayesaverage).collect(toSingleton()).intValue());
        for (Results results : ((Poll) item.getMaxplaytimeOrMinageOrMinplaytime().get(0)).getResults()) {
            String numPlayers = results.getNumplayers();
            Integer best = results.getResult().stream().filter(v -> v.getValue().equals("Best")).map(Result::getNumvotes).collect(toSingleton());
            Integer recommended = results.getResult().stream().filter(v -> v.getValue().equals("Recommended")).map(Result::getNumvotes).collect(toSingleton());
            Integer notRecommended = results.getResult().stream().filter(v -> v.getValue().equals("Not Recommended")).map(Result::getNumvotes).collect(toSingleton());
            Recomendation recomendation = new Recomendation(best, notRecommended, numPlayers, recommended);
            recomendation.setGraDescription(gra);
            recommendationsSet.add(recomendation);
        }
        gra.setRecomendations(recommendationsSet);
    }
}
