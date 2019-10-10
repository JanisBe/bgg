package com.janis.bgg.demo.dao.Impl;

import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.entities.entity.Game;
import org.springframework.stereotype.Component;

@Component
public abstract class GryDescDaoImpl implements GryDescDao {

    public Game zapiszGre(Game gra) {
        return save(gra);
    }

}
