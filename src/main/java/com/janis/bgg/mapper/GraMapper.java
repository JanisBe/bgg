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

import static java.lang.Integer.parseInt;

@Mapper(componentModel = "spring")
public abstract class GraMapper {

    @Autowired
    private GryDescDao gryDescDao;

//    @Mapping(target = "price", source = "userComment")
//    @Mapping(target = "year", source = "yearPublished")
//    public abstract GraDto graToGraDto(Gra gra);
//
//    @Mapping(target = "yearPublished", source = "year")
//    public abstract Gra graDtoToGra(GraDto dto);
//
//    @Mapping(target = "players", ignore = true)
//    @Mapping(target = "expansion", ignore = true)
//    @Mapping(target = "year", source = "yearPublished")
//    @Mapping(target = "gameId", source = "id")
//    public abstract GraDto graDescToGraDto(Game gra);
//
//    @Mapping(target = "price", source = "userComment")
//    @Mapping(target = "description", source = "name")
//    @Mapping(target = "id", source = "gameId")
//    public abstract Game graToGryDesc(Gra gra);

    @Mapping(target = "expansionId", source = "expansion.gameId")
    @Mapping(target = "recomendations", ignore = true)
    @Mapping(target = "description", source = "name")
    @Mapping(target = "yearPublished", source = "year")
    public abstract Game graDtoToGraDesc(GraDto dto);

    @AfterMapping
    protected void graDtoToGraDesc(GraDto dto, @MappingTarget Game game) {
        String players = dto.getPlayers();
        String[] noOfPlayers = players.split(" - ");
        if (noOfPlayers.length > 1) {
            game.setMinPlayers(parseInt(noOfPlayers[0]));
            game.setMaxPlayers(parseInt(noOfPlayers[1]));
        } else {
            game.setMinPlayers(parseInt(players));
            game.setMaxPlayers(parseInt(players));
        }
        game.setId(gryDescDao.findByGameId(Math.toIntExact(dto.getGameId())).getId());
    }

    @Mapping(target = "numPlays", ignore = true)
    @Mapping(target = "userComment", source = "price")
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "gameId", source = "id")
    public abstract Gra gameTOGra(Game gra);

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

    public List<Gra> gameTOGra(List<Game> gry) {
        List<Gra> result = Lists.newArrayList();
        for (Game gra : gry) {
            result.add(gameTOGra(gra));
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

    @Mapping(target = "id", ignore = true)
    public abstract Game gameToGame(Game game);
}
