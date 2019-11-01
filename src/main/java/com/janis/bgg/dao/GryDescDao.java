package com.janis.bgg.dao;

import com.janis.bgg.entities.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GryDescDao extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
    Game findByName(String name);

    List<Game> findByMinPlayersGreaterThanEqualAndMaxPlayersGreaterThanEqualOrderByAverageRatingDesc(Integer minPlayers, Integer maxPlayers);

    Game findByGameId(int gameId);
    Game findById(int id);

    @Query(value = "Select game_id from game", nativeQuery = true)
    List<Integer> findAllIds();

}
