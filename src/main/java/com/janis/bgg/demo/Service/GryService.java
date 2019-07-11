package com.janis.bgg.demo.Service;

import com.janis.bgg.demo.Dao.GryDao;
import com.janis.bgg.demo.Entity.Gra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class GryService {

    @Autowired
    private GryDao dao;

    public List<Gra> findGameByNumOfPlayers(Integer noOfPlayers) {
        if (noOfPlayers < 0) {
            throw new InvalidParameterException("Liczba graczy nie może być mniejsza niż 0");
        }
        return dao.findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(noOfPlayers, noOfPlayers);
    }

    public List<Gra> findAllOrderBy() {
        return dao.findAllByOrderByAverageRatingDesc();
    }

    public List<Gra> findAll() {
        return dao.findAll();
    }

    public List<Gra> findGracze(Integer no) {
        return dao.findGracze(no);
    }

}
