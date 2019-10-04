package com.janis.bgg.demo.mapper;

import com.google.common.collect.Sets;
import com.janis.bgg.demo.entity.Designer;
import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.entity.Mechanic;
import com.janis.bgg.demo.xml.Items3.Item;
import com.janis.bgg.demo.xml.Items3.Playingtime;
import com.janis.bgg.demo.xml.Items3.Rank;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {
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

    @Mapping(target = "yearPublished", source = "yearpublished.value")
    @Mapping(target = "recomendations", source = "")
    @Mapping(target = "recomendation", source = "")
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

    @AfterMapping
    protected void nameMapper(Item item, @MappingTarget GraDescription gra) {
        String name = item.getName().stream().filter(t -> t.getType().equals("primary")).collect(Collectors.toList()).get(0).getValue();
        gra.setName(name);
        Set<Mechanic> mechanicList = Sets.newHashSet();
        Set<Designer> designerList = Sets.newHashSet();
        item.getLink().stream().filter(t -> t.getType().equals("boardgamemechanic")).map(m -> m.getValue()).forEach(mechanic -> mechanicList.add(new Mechanic(mechanic)));
        gra.setMechanics(mechanicList);
        item.getLink().stream().filter(t -> t.getType().equals("boardgamedesigner")).map(m -> m.getValue()).forEach(designer -> designerList.add(new Designer(designer)));
        gra.setDesigners(designerList);
        gra.setPlayingTime(new Integer(item.getMaxplaytimeOrMinageOrMinplaytime().stream().filter(t -> t instanceof Playingtime).map(p -> ((Playingtime) p).getValue()).collect(toSingleton())));
        BigDecimal boardGameRank = item.getStatistics().getRatings().getRanks().getRank().stream().filter(r -> r.getFriendlyname().equals("Board Game Rank")).map(Rank::getBayesaverage).collect(toSingleton());
        gra.setRank(boardGameRank.intValue());
    }
}
