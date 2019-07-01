package com.janis.bgg.demo.Dao;

import com.janis.bgg.demo.entity.GraDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GryDescDao extends JpaRepository<GraDescription, Long> {
}
