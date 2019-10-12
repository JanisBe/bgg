package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entities.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GryDescDao extends JpaRepository<Game, Long> {

    Game findByName(String name);

    Game findById(int id);

    @Query(value = "Select game_id from game", nativeQuery = true)
    List<Integer> findAllIds();
}
