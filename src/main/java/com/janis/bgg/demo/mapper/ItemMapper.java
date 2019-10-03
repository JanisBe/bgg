package com.janis.bgg.demo.mapper;

import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.xml.items.Item;

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
    }
}
