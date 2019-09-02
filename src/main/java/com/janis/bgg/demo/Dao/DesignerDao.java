package com.janis.bgg.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janis.bgg.demo.Entity.Designer;

public interface DesignerDao extends JpaRepository<Designer, Long> {

    public Designer findDesignerByDesignerName(String designerName);
}
