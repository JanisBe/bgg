package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entities.entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendationDao extends JpaRepository<Recomendation, Long> {
}
