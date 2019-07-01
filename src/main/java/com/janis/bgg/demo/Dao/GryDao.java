package com.janis.bgg.demo.Dao;

import com.janis.bgg.demo.entity.Gra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GryDao extends JpaRepository<Gra, Long> {
    List<Gra> findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(Integer minPlayers, Integer maxPlayers);

    @Query("select gra from Gra gra where minPlayers < ?1 and maxPlayers >  ?1 order by gra.name, gra.rank")
    List<Gra> findGracze(Integer noOfPlayers);

    List<Gra> findAllByOrderByAverageRatingDesc();
}
