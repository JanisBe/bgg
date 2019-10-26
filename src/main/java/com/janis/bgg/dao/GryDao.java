package com.janis.bgg.dao;

import com.janis.bgg.entities.entity.Gra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GryDao extends JpaRepository<Gra, Long> {

    @Query("select gra from Gra gra where gra.minPlayers < ?1 and gra.maxPlayers >  ?1 order by gra.name, gra.rank")
    List<Gra> findGracze(Integer noOfPlayers);

    List<Gra> findAllByOrderByAverageRatingDesc();
}
