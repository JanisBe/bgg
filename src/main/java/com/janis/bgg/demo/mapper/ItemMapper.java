package com.janis.bgg.demo.mapper;

import com.google.common.collect.Lists;
import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.entity.Mechanic;
import com.janis.bgg.demo.xml.items.Item;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {
    @Mapping(target = "yearPublished", source = "yearpublished.value")
    @Mapping(target = "recomendations", source = "")
    @Mapping(target = "recomendation", source = "")
    @Mapping(target = "rank", source = "")
    @Mapping(target = "playingTime", ignore = true)
    @Mapping(target = "minPlayers", source = "minplayers.value")
    @Mapping(target = "mechanics", source = "")
    @Mapping(target = "maxPlayers", source = "maxplayers.value")
    @Mapping(target = "designers", source = "")
    @Mapping(target = "bggRating", source = "")
    @Mapping(target = "averageRating", source = "")
    @Mapping(target = "name", ignore = true)
    public abstract GraDescription itemToGraMapper(Item item);

    @AfterMapping
    protected void nameMapper(Item item, @MappingTarget GraDescription gra) {
        String name = item.getName().stream().filter(t -> t.getType().equals("primary")).collect(Collectors.toList()).get(0).getValue();
        gra.setName(name);
        List<Mechanic> mechanicList = Lists.newArrayList();
        List<String> mechanicStringList = item.getLink().stream().filter(t -> t.getType().equals("boardgamemechanic")).map(m -> m.getValue()).collect(Collectors.toList());
        mechanicStringList.forEach(mechanic -> mechanicList.add(new Mechanic(mechanic)));

    }
}
