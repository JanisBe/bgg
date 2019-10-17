package com.janis.bgg.dao;

import com.janis.bgg.entities.dto.SearchCriteria;
import com.janis.bgg.entities.entity.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Primary
public interface GraRepositoryCustom {

    List<Game> szukanie(SearchCriteria searchCriteria);

    Specification<Game> searchGameUsingSpecification(SearchCriteria searchCriteria);
}
