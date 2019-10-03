package com.janis.bgg.demo.mapper;

import java.util.Set;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Sets;
import com.janis.bgg.demo.dao.DesignerDao;
import com.janis.bgg.demo.dao.GryDescDao;
import com.janis.bgg.demo.dao.MechanicDao;
import com.janis.bgg.demo.entity.Designer;
import com.janis.bgg.demo.entity.GraDescription;
import com.janis.bgg.demo.entity.Mechanic;
import com.janis.bgg.demo.jsonObjects.JsonGraDescription;

@Mapper(componentModel = "spring")

public abstract class GraDescriptionMapper {
    @Autowired
    private DesignerDao designerDao;

    @Autowired
    private MechanicDao mechanicDao;

    @Autowired
    private GryDescDao gryDescDao;

    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "gameId", source = "id")
    public abstract JsonGraDescription mapGryToGra(GraDescription graDescription);

    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "recomendations", source = "playerPollResults")
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "id", source = "gameId")
    public abstract GraDescription mapGraToGry(JsonGraDescription jsonGraDescription);

    @AfterMapping
    protected void mapuj(JsonGraDescription jsonGraDescription, @MappingTarget GraDescription gra) {
        Set<Designer> designerSet = Sets.newHashSet();
        for (String designerName : jsonGraDescription.getDesigners()) {
            Designer designer = designerDao.findDesignerByDesignerName(designerName);
            if (designer != null) {
                designerSet.add(designer);
            }
            else {
                designerSet.add(new Designer(designerName));
            }
        }
        Set<Mechanic> mechanicSet = Sets.newHashSet();
        for (String mechanicName : jsonGraDescription.getMechanics()) {
            Mechanic mechanic = mechanicDao.findMechanicByName(mechanicName);
            if (mechanic != null) {
                mechanicSet.add(mechanic);
            }
            else {
                mechanicSet.add(new Mechanic(mechanicName));
            }
        }
        gra.setMechanics(mechanicSet);
        gra.setDesigners(designerSet);

        // for(Recomendation rec : gra.getRecomendation()){
        // rec.getGraDescription(gra);
        // }
    }
}
