package com.janis.bgg.demo.Dao.Impl;

import org.springframework.stereotype.Component;

import com.janis.bgg.demo.Dao.GryDescDao;
import com.janis.bgg.demo.Entity.GraDescription;

@Component
public abstract class GryDescDaoImpl implements GryDescDao {

    public GraDescription zapiszGre(GraDescription gra) {
        return save(gra);
    }

}
