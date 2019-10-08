package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entity.GraDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GryDescDao extends JpaRepository<GraDescription, Long> {

    public GraDescription findByName(String name);

    @Query(value = "Select id from GraDescription", nativeQuery = true)
    public List<Integer> findAllIds();
}
