package com.janis.bgg.demo.Dao;

import com.janis.bgg.demo.Entity.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendationDao extends JpaRepository<Recomendation, Long> {
}
