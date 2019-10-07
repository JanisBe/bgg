package com.janis.bgg.demo.mapper;

import com.janis.bgg.demo.dto.GraDto;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.GraDescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GraMapper {

    @Mapping(target = "year", source = "yearPublished")
    abstract GraDto graToGraDto(Gra gra);

    @Mapping(target = "yearPublished", source = "year")
    abstract Gra graDtoToGra(GraDto dto);

    @Mapping(target = "year", source = "yearPublished")
    @Mapping(target = "gameId", source = "id")
    abstract GraDto graDescToGraDto(GraDescription gra);


    @Mapping(target = "yearPublished", source = "year")
    @Mapping(target = "id", source = "gameId")
    abstract GraDescription graDtoToGraDesc(GraDto dto);


    @Mapping(target = "id", source = "gameId")
    abstract GraDescription graToGryDesc(Gra gra);

    @Mapping(target = "rating", source = "")
    @Mapping(target = "gameId", source = "id")
    abstract Gra graDescToGra(GraDescription gra);
}
