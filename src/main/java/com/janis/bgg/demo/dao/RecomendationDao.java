package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendationDao extends JpaRepository<Recomendation, Long> {
}
