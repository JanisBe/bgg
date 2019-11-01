package com.janis.bgg.mapper;

import com.google.common.collect.Sets;
import com.janis.bgg.dao.DesignerDao;
import com.janis.bgg.dao.MechanicDao;
import com.janis.bgg.entities.entity.Designer;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Mechanic;
import com.janis.bgg.entities.entity.Recomendation;
import com.janis.bgg.entities.xml.Items3.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.janis.bgg.constants.AppConstants.*;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {
    @Autowired
    private DesignerDao designerDao;

    @Autowired
    private MechanicDao mechanicDao;

    @Mapping(target = "gameId", source = "id")
    @Mapping(target = "expansionId", ignore = true)
    @Mapping(target = "weight", ignore = true)
    @Mapping(target = "recomendations", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "rank", ignore = true)
    @Mapping(target = "playingTime", ignore = true)
    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "bggRating", ignore = true)
    @Mapping(target = "averageRating", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "minPlayers", source = "minplayers.value")
    @Mapping(target = "maxPlayers", source = "maxplayers.value")
    @Mapping(target = "yearPublished", source = "yearpublished.value")
    public abstract Game itemToGraMapper(Item item);

    @AfterMapping
    protected void nameMapper(Item item, @MappingTarget Game gra) {
        String name = item.getName().stream().filter(t -> t.getType().equals(PRIMARY)).collect(toSingleton()).getValue();
        gra.setName(name);
        Set<Mechanic> mechanicsSet = Sets.newHashSet();
        Set<Designer> designersSet = Sets.newHashSet();
        Set<Recomendation> recommendationsSet = Sets.newHashSet();
        item.getLink().stream().filter(t -> t.getType().equals(MECHANIC)).map(Link::getValue).forEach(mechanic -> {
            Mechanic existingMechanic = mechanicDao.findMechanicByName(mechanic);
            if (existingMechanic != null) {
                mechanicsSet.add(existingMechanic);
            } else {
                mechanicsSet.add(new Mechanic(mechanic));
            }
        });
        gra.setMechanics(mechanicsSet);
        item.getLink().stream().filter(t -> t.getType().equals(DESIGNER)).map(Link::getValue).forEach(designer -> {
            Designer existingDesigner = designerDao.findDesignerByDesignerName(designer);
            if (existingDesigner != null) {
                designersSet.add(existingDesigner);
            } else {
                designersSet.add(new Designer(designer));
            }
        });
        gra.setDesigners(designersSet);
        gra.setPlayingTime(item.getMaxplaytimeOrMinageOrMinplaytime().stream().filter(t -> t instanceof Playingtime).map(p -> ((Playingtime) p).getValue()).collect(toSingleton()));
        gra.setRank(item.getStatistics().getRatings().getRanks().getRank().stream().filter(r -> r.getFriendlyname().equals(RANK)).map(Rank::getBayesaverage).collect(toSingleton()).intValue());
        for (Results results : ((Poll) item.getMaxplaytimeOrMinageOrMinplaytime().get(0)).getResults()) {
            String numPlayers = results.getNumplayers();
            if (results.getResult() != null && !results.getResult().isEmpty()) {
                Integer best = results.getResult().stream().filter(v -> v.getValue().equals(BEST)).map(Result::getNumvotes).collect(toSingleton());
                Integer recommended = results.getResult().stream().filter(v -> v.getValue().equals(RECOMMENDED)).map(Result::getNumvotes).collect(toSingleton());
                Integer notRecommended = results.getResult().stream().filter(v -> v.getValue().equals(NOT_RECOMMENDED)).map(Result::getNumvotes).collect(toSingleton());
                Recomendation recomendation = new Recomendation(best, notRecommended, numPlayers, recommended);
                recomendation.setGame(gra);
                recommendationsSet.add(recomendation);
            }
        }
        gra.setRecomendations(recommendationsSet);
        gra.setBggRating(round(item.getStatistics().getRatings().getBayesaverage().getValue()));
        gra.setAverageRating(round(item.getStatistics().getRatings().getAverage().getValue()));
        gra.setWeight(round(item.getStatistics().getRatings().getAverageweight().getValue()));
        List<Link> expansion = item.getLink().stream()
                .filter(t -> t.getType().equals(EXPANSION))
                .collect(Collectors.toList());
        if (expansion.size() == 1 && expansion.get(0).isInbound() != null) {
            gra.setExpansionId(expansion.get(0).getId().intValue());
        }
    }

    private Double round(BigDecimal d) {
        BigDecimal res = d.setScale(2, BigDecimal.ROUND_HALF_UP);
        return res.doubleValue();
    }

    private <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                });
    }
}
