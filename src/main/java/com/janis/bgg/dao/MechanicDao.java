package com.janis.bgg.dao;

import com.janis.bgg.entities.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicDao extends JpaRepository<Mechanic, Long> {

    Mechanic findMechanicByName(String name);
}
