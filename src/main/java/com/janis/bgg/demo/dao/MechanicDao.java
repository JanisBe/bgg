package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicDao extends JpaRepository<Mechanic, Long> {

    public Mechanic findMechanicByName(String name);
}
