package com.janis.bgg.demo.Mapper;

import com.janis.bgg.demo.Dto.GraDto;
import com.janis.bgg.demo.entity.Gra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GraMapper {
    abstract GraDto graToGraDto(Gra gra);


    // @Mapping(target = "gra.bggRating", ignore = true)
    @Mapping(target = "gra.yearPublished", ignore = true)
    @Mapping(target = "gra.numPlayes", ignore = true)
    @Mapping(target = "gra.userComment", ignore = true)
    @Mapping(target = "gra.rating", ignore = true)
    @Mapping(target = "gra.expansionId", ignore = true)
    abstract Gra graDtoToGra(GraDto dto);

}
