package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entities.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicDao extends JpaRepository<Mechanic, Long> {

    Mechanic findMechanicByName(String name);
}
