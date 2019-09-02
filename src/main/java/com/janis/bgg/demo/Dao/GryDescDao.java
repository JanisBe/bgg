package com.janis.bgg.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janis.bgg.demo.Entity.GraDescription;

@Repository
public interface GryDescDao extends JpaRepository<GraDescription, Long> {

    public GraDescription findByName(String name);
}
