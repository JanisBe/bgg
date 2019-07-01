package com.janis.bgg.demo.Mapper;

import com.janis.bgg.demo.Dto.GraDto;
import com.janis.bgg.demo.entity.Gra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class GraMapper {
    abstract GraDto graToGraDto(Gra gra);


    abstract Gra graDtoToGra(GraDto dto);

}
