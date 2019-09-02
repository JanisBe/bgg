package com.janis.bgg.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janis.bgg.demo.Entity.Mechanic;

public interface MechanicDao extends JpaRepository<Mechanic, Long> {

    public Mechanic findMechanicByName(String name);
}
