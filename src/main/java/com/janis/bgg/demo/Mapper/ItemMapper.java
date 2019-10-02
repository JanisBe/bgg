package com.janis.bgg.demo.Mapper;

import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.xml.items.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {

    @Mapping(target = "yearPublished", source = "yearpublished.value")
    @Mapping(target = "recomendations", source = "")
    @Mapping(target = "recomendation", source = "")
    @Mapping(target = "rank", source = "")
    @Mapping(target = "playingTime", ignore = true)
    @Mapping(target = "minPlayers", source = "")
    @Mapping(target = "mechanics", source = "")
    @Mapping(target = "maxPlayers", source = "")
    @Mapping(target = "designers", source = "")
    @Mapping(target = "bggRating", source = "")
    @Mapping(target = "averageRating", source = "")
    @Mapping(target = "name", ignore = true)
    public abstract GraDescription itemToGraMapper(Item item);
}
