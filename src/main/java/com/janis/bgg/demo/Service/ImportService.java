package com.janis.bgg.demo.Service;

import com.janis.bgg.demo.Dao.GryDao;
import com.janis.bgg.demo.Entity.Gra;
import com.janis.bgg.demo.Utils.ImporterUtils;
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
