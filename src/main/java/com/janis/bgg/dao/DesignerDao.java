package com.janis.bgg.dao;

import com.janis.bgg.entities.entity.Designer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignerDao extends JpaRepository<Designer, Long> {

    Designer findDesignerByDesignerName(String designerName);
}
