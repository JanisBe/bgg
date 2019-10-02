package com.janis.bgg.demo.dao;

import com.janis.bgg.demo.entity.Designer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignerDao extends JpaRepository<Designer, Long> {

    public Designer findDesignerByDesignerName(String designerName);
}
