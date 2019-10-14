package com.janis.bgg.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.janis.bgg.demo.entities.dto.GameSearchCriteriaDto;
import com.janis.bgg.demo.entities.entity.Game;

@Repository
@Transactional
public interface GryDescDao extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
    Game findByName(String name);

    Game findById(int id);

    @Query(value = "Select game_id from game", nativeQuery = true)
    List<Integer> findAllIds();

    List<Game> findGamesByCriteria(GameSearchCriteriaDto searchCriteria);

    Specification<Game> getItemsSpecification(GameSearchCriteriaDto searchCriteria);
}
