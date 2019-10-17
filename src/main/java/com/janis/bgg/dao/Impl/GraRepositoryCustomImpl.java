package com.janis.bgg.dao.Impl;

import com.janis.bgg.dao.GraRepositoryCustom;
import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Game_;
import com.janis.bgg.utils.JpaPredicateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GraRepositoryCustomImpl implements GraRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<Game> szukanie(SearchCriteria searchCriteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        JpaPredicateList predicates = new JpaPredicateList();
        predicates.add(cb.like(root.get(Game_.name), searchCriteria.getName()));
        Predicate minPlayers = cb.greaterThan(root.get(Game_.minPlayers), searchCriteria.getMinPlayers());
        Predicate maxPlayers = cb.greaterThan(root.get(Game_.maxPlayers), searchCriteria.getMaxPlayers());
        predicates.add(cb.and(minPlayers, maxPlayers));
        predicates.add(cb.isMember(searchCriteria.getMechanic(), root.get(Game_.mechanics)));
        predicates.add(cb.isMember(searchCriteria.getDesigner(), root.get(Game_.designers)));
        cq.where(predicates.asArray());
        TypedQuery<Game> query = em.createQuery(cq);

        //https://www.baeldung.com/spring-data-criteria-queries#specifications
        // https://www.javappa.com/blog/backend/spring-data-jpa-ciekawy-przypadek
        return query.getResultList();
//        return new ArrayList<>();
    }

    @Override
    public Specification<Game> searchGameUsingSpecification(SearchCriteria searchCriteria) {

        return (root, query, criteriaBuilder) -> {
            JpaPredicateList predicates = new JpaPredicateList();

            predicates.add(criteriaBuilder.like(root.get("name"), searchCriteria.getName()));
            Predicate minPlayers = criteriaBuilder.greaterThan(root.get("minPlayers"), searchCriteria.getMinPlayers());
            Predicate maxPlayers = criteriaBuilder.greaterThan(root.get("maxPlayers"), searchCriteria.getMaxPlayers());
            predicates.add(criteriaBuilder.and(minPlayers, maxPlayers));
            predicates.add(criteriaBuilder.isMember(searchCriteria.getMechanic(), root.get("mechanics")));
            predicates.add(criteriaBuilder.isMember(searchCriteria.getDesigner(), root.get("designers")));

            return criteriaBuilder.and(predicates.asArray());
        };
    }
}
