package com.janis.bgg.demo.dao.Impl;

import com.google.common.collect.Lists;
import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.entities.dto.GameSearchCriteriaDto;
import com.janis.bgg.demo.entities.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class GryDescDaoImpl implements GryDescDao {
    @Autowired
    EntityManager em;

    public Game zapiszGre(Game gra) {
        return save(gra);
    }

    public List<Game> findGamesByCriteria(GameSearchCriteriaDto searchCriteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> game = cq.from(Game.class);
        List<Predicate> predicates = Lists.newArrayList();
        //https://www.baeldung.com/spring-data-criteria-queries#specifications
        return new ArrayList<>();

    }
}
