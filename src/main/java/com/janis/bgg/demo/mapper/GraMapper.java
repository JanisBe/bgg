package com.janis.bgg.demo.mapper;

import com.google.common.collect.Lists;
import com.janis.bgg.demo.dto.GraDto;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.entity.GraDescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GraMapper {

    @Mapping(target = "year", source = "yearPublished")
    public abstract GraDto graToGraDto(Gra gra);

    @Mapping(target = "yearPublished", source = "year")
    public abstract Gra graDtoToGra(GraDto dto);

    @Mapping(target = "year", source = "yearPublished")
    @Mapping(target = "gameId", source = "id")
    public abstract GraDto graDescToGraDto(GraDescription gra);


    @Mapping(target = "yearPublished", source = "year")
    @Mapping(target = "id", source = "gameId")
    public abstract GraDescription graDtoToGraDesc(GraDto dto);


    @Mapping(target = "id", source = "gameId")
    public abstract GraDescription graToGryDesc(Gra gra);

    @Mapping(target = "rating", source = "")
    @Mapping(target = "gameId", source = "id")
    public abstract Gra graDescToGra(GraDescription gra);


    public List<Gra> graDescToGra(List<GraDescription> gry) {
        List<Gra> result = Lists.newArrayList();
        for (GraDescription gra : gry) {
            result.add(graDescToGra(gra));
        }
        return result;
    }

}
