package com.janis.bgg.demo.dao.Impl;

import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.entity.GraDescription;
import org.springframework.stereotype.Component;

@Component
public abstract class GryDescDaoImpl implements GryDescDao {

    public GraDescription zapiszGre(GraDescription gra) {
        return save(gra);
    }

}
