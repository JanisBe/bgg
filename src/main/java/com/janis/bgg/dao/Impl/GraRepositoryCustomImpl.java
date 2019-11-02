package com.janis.bgg.dao.Impl;

import com.janis.bgg.dao.GraRepositoryCustom;
import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Game_;
import com.janis.bgg.utils.JpaPredicateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GraRepositoryCustomImpl implements GraRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<Game> searchGamesUsingCriteria(SearchCriteria searchCriteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.where(getJpaPredicateList(searchCriteria, root, cb).asArray());
        TypedQuery<Game> query = em.createQuery(cq);

        //https://www.baeldung.com/spring-data-criteria-queries#specifications
        // https://www.javappa.com/blog/backend/spring-data-jpa-ciekawy-przypadek
        return query.getResultList();
//        return new ArrayList<>();
    }

    @Override
    public Specification<Game> searchGameUsingSpecification(SearchCriteria searchCriteria) {

        return (root, query, cb) -> {
            //
            return cb.and(getJpaPredicateList(searchCriteria, root, cb).asArray());
        };
    }

    private JpaPredicateList getJpaPredicateList(SearchCriteria searchCriteria, Root<Game> root, CriteriaBuilder cb) {
        JpaPredicateList predicates = new JpaPredicateList();

        String name = searchCriteria.getName();
        if (name != null && !StringUtils.isEmptyOrWhitespace(name)) {
            predicates.add(cb.like(cb.lower(root.get(Game_.name)), "%" + name.toLowerCase() + "%"));
        }
        if (searchCriteria.getMinPlayers() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(Game_.minPlayers), searchCriteria.getMinPlayers()));
        }
        if (searchCriteria.getMaxPlayers() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(Game_.maxPlayers), searchCriteria.getMaxPlayers()));
        }
        if (searchCriteria.getMechanic() != null) {
            predicates.add(cb.isMember(searchCriteria.getMechanic(), root.get(Game_.mechanics)));
        }
        if (searchCriteria.getDesigner() != null) {
            predicates.add(cb.isMember(searchCriteria.getDesigner(), root.get(Game_.designers)));
        }
        return predicates;
    }
}
