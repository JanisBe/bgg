package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entities.entity.Designer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignerDao extends JpaRepository<Designer, Long> {

    Designer findDesignerByDesignerName(String designerName);
}
