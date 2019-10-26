package com.janis.bgg.service;

import com.janis.bgg.dao.GraRepositoryCustom;
import com.janis.bgg.dao.GryDao;
import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.entities.dto.GraDto;
import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Gra;
import com.janis.bgg.mapper.GraMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GryService {
    private final GryDescDao gryDescDao;
    private final GryDao gryDao;
    private final GraRepositoryCustom graRepositoryCustom;
    private final GraMapper graMapper;


    public GryService(GryDescDao gryDescDao, GryDao dao, GraRepositoryCustom graRepositoryCustom, GraMapper graMapper) {
        this.gryDescDao = gryDescDao;
        this.gryDao = dao;
        this.graRepositoryCustom = graRepositoryCustom;
        this.graMapper = graMapper;
    }

    public List<Game> findGameByNumOfPlayers(Integer noOfPlayers) {
        if (noOfPlayers < 0) {
            throw new InvalidParameterException("Liczba graczy nie może być mniejsza niż 0");
        }
        return gryDescDao.findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(noOfPlayers, noOfPlayers)
                .stream().sorted(Comparator.comparing(Game::getName)).collect(Collectors.toList());
    }

    public List<Gra> findAllOrderByAvgRating() {
        return gryDao.findAllByOrderByAverageRatingDesc();
    }

    public List<Game> findAll() {
        return gryDescDao.findAll().stream().sorted(Comparator.comparing(Game::getName)).collect(Collectors.toList());
    }

    public List<Gra> findGracze(Integer no) {
        return gryDao.findGracze(no);
    }

    public List<Game> findAllGames(SearchCriteria searchCriteria) {
        return gryDescDao.findAll(graRepositoryCustom.searchGameUsingSpecification(searchCriteria));
    }

    public List<GraDto> findAllGamesToDto(SearchCriteria searchCriteria) {
        return graMapper.gameToGraDto(graRepositoryCustom.searchGamesUsingCriteria(searchCriteria));
    }

    public Game findById(int id) {
        return gryDescDao.findById(id);
    }

    public Game saveGame(Game game) {
        return gryDescDao.save(game);
    }
}
