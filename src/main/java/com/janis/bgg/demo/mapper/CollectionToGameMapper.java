package com.janis.bgg.demo.mapper;

import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.xml.collection.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CollectionToGameMapper {

    @Mapping(target = "yearPublished", source = "yearpublished")
    @Mapping(target = "userComment", source = "comment")
    @Mapping(target = "thumbnail", source = "thumbnail")
    @Mapping(target = "rating", source = "")
    @Mapping(target = "rank", source = "")
    @Mapping(target = "playingTime", source = "")
    @Mapping(target = "numPlays", source = "numplays")
    @Mapping(target = "name", source = "name.content")
    @Mapping(target = "minPlayers", source = "")
    @Mapping(target = "maxPlayers", source = "")
    @Mapping(target = "image", source = "image")
    @Mapping(target = "gameId", source = "objectid")
    @Mapping(target = "expansionId", source = "")
    @Mapping(target = "bggRating", source = "")
    @Mapping(target = "averageRating", source = "")
    public abstract Gra mapCollectionToGra(Item collection);
}
