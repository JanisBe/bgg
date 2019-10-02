package com.janis.bgg.demo.Mapper;

import com.janis.bgg.demo.dto.GraDto;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.GraDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GraMapper {

    GraDto graToGraDto(Gra gra);

    Gra graDtoToGra(GraDto dto);

    GraDto graDescToGraDto(GraDescription gra);

    GraDescription graDtoToGraDesc(GraDto dto);

}
