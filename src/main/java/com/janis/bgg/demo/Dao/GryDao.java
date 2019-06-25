package com.janis.bgg.demo.Dao;

import com.janis.bgg.demo.entity.Gra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GryDao extends JpaRepository<Gra, Long> {
    List<Gra> findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(Integer minPlayers, Integer maxPlayers);

    List<Gra> findAllByOrderByAverageRatingDesc();
}
