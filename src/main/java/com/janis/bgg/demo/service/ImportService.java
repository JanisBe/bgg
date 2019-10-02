package com.janis.bgg.demo.service;

import com.janis.bgg.demo.dao.GryDao;
import com.janis.bgg.demo.entity.Gra;
import com.janis.bgg.demo.utils.ImporterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportService {
    @Autowired
    private ImporterUtils importer;
    @Autowired
    private GryDao gryDao;

    public List<Gra> importGamesFromBgg() {

        return gryDao.findAll();
    }
}
