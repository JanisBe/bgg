package com.janis.bgg.dao;

import com.janis.bgg.entities.entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendationDao extends JpaRepository<Recomendation, Long> {
}
