package com.janis.bgg.demo.service;

import com.janis.bgg.demo.dao.GryDao;
import com.janis.bgg.demo.entity.Gra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GryService {

    @Autowired
    private GryDao dao;

    public List<Gra> findGameByNumOfPlayers(Integer noOfPlayers) {
        if (noOfPlayers < 0) {
            throw new InvalidParameterException("Liczba graczy nie może być mniejsza niż 0");
        }
        return dao.findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(noOfPlayers, noOfPlayers)
                .stream().sorted(Comparator.comparing(Gra::getName)).collect(Collectors.toList());
    }

    public List<Gra> findAllOrderByAvgRating() {
        return dao.findAllByOrderByAverageRatingDesc();
    }

    public List<Gra> findAll() {
        return dao.findAll().stream().sorted(Comparator.comparing(Gra::getName)).collect(Collectors.toList());
    }

    public List<Gra> findGracze(Integer no) {
        return dao.findGracze(no);
    }

}
