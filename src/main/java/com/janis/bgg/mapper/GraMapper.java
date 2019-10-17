package com.janis.bgg.mapper;

import com.google.common.collect.Lists;
import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Gra;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GraMapper {

    @Autowired
    private GryDescDao gryDescDao;

    @Mapping(target = "year", source = "yearPublished")
    public abstract GraDto graToGraDto(Gra gra);

    @Mapping(target = "yearPublished", source = "year")
    public abstract Gra graDtoToGra(GraDto dto);

    @Mapping(target = "year", source = "yearPublished")
    @Mapping(target = "gameId", source = "id")
    public abstract GraDto graDescToGraDto(Game gra);


    @Mapping(target = "yearPublished", source = "year")
    @Mapping(target = "id", source = "gameId")
    public abstract Game graDtoToGraDesc(GraDto dto);


    @Mapping(target = "id", source = "gameId")
    public abstract Game graToGryDesc(Gra gra);

    @Mapping(target = "rating", source = "")
    @Mapping(target = "gameId", source = "id")
    public abstract Gra graDescToGra(Game gra);

    @Mapping(target = "expansion", ignore = true)
    @Mapping(target = "gameId", source = "id")
    @Mapping(target = "year", source = "yearPublished")
    @Mapping(target = "players", ignore = true)
    public abstract GraDto gameToGraDto(Game gra);

    @AfterMapping
    protected void gameToGraDTO(Game gra, @MappingTarget GraDto graDto) {
        String result;
        if (gra.getMinPlayers() == gra.getMaxPlayers()) {
            result = gra.getMinPlayers().toString();
        } else {
            result = gra.getMinPlayers() + " - " + gra.getMaxPlayers();
        }
        graDto.setPlayers(result);
        if (gra.getExpansionId() != null) {
            Game expansion = gryDescDao.findById(gra.getExpansionId());
            graDto.setExpansion(gameToGraDto(expansion));
        }
    }

    public List<Gra> graDescToGra(List<Game> gry) {
        List<Gra> result = Lists.newArrayList();
        for (Game gra : gry) {
            result.add(graDescToGra(gra));
        }
        return result;
    }

    public List<GraDto> gameToGraDto(List<Game> gry) {
        List<GraDto> result = Lists.newArrayList();
        for (Game gra : gry) {
            result.add(gameToGraDto(gra));
        }
        return result;
    }
}
