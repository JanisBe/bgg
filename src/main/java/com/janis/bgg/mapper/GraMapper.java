package com.janis.bgg.mapper;

import com.google.common.collect.Lists;
import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.entity.Game;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.lang.Integer.parseInt;

@Mapper(componentModel = "spring")
public abstract class GraMapper {

    @Autowired
    private GryDescDao gryDescDao;

    @Mapping(target = "expansionId", source = "expansion.gameId")
    @Mapping(target = "recomendations", ignore = true)
    @Mapping(target = "description", source = "name")
    @Mapping(target = "yearPublished", source = "year")
    public abstract Game graDtoToGraDesc(GraDto dto);

    @AfterMapping
    protected void graDtoToGraDesc(GraDto dto, @MappingTarget Game game) {
        String players = dto.getPlayers();
        String[] noOfPlayers = players.split("\\s?-\\s?");
        if (noOfPlayers.length > 1) {
            game.setMinPlayers(parseInt(noOfPlayers[0]));
            game.setMaxPlayers(parseInt(noOfPlayers[1]));
        } else {
            game.setMinPlayers(parseInt(players));
            game.setMaxPlayers(parseInt(players));
        }
        game.setId(gryDescDao.findByGameId(Math.toIntExact(dto.getGameId())).getId());
    }

    @Mapping(target = "expansion", ignore = true)
    @Mapping(target = "year", source = "yearPublished")
    @Mapping(target = "players", ignore = true)
    public abstract GraDto gameToGraDto(Game gra);

    @AfterMapping
    protected void gameToGraDTO(Game gra, @MappingTarget GraDto graDto) {
        String players;
        if (gra.getMinPlayers().equals(gra.getMaxPlayers())) {
            players = gra.getMinPlayers().toString();
        } else {
            players = gra.getMinPlayers() + " - " + gra.getMaxPlayers();
        }
        graDto.setPlayers(players);
        if (gra.getExpansionId() != null) {
            Game expansion = gryDescDao.findByGameId(gra.getExpansionId());
            graDto.setExpansion(gameToGraDto(expansion));
        }
    }

    public List<GraDto> gameToGraDto(List<Game> gry) {
        List<GraDto> result = Lists.newArrayList();
        for (Game gra : gry) {
            result.add(gameToGraDto(gra));
        }
        return result;
    }

    @Mapping(target = "id", ignore = true)
    public abstract Game gameToGame(Game game);
}
