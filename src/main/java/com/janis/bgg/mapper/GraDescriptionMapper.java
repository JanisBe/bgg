package com.janis.bgg.mapper;

import com.google.common.collect.Sets;
import com.janis.bgg.dao.DesignerDao;
import com.janis.bgg.dao.GryDescDao;
import com.janis.bgg.dao.MechanicDao;
import com.janis.bgg.entities.entity.Designer;
import com.janis.bgg.entities.entity.Game;
import com.janis.bgg.entities.entity.Mechanic;
import com.janis.bgg.entities.jsonObjects.JsonGraDescription;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class GraDescriptionMapper {
    @Autowired
    private DesignerDao designerDao;

    @Autowired
    private MechanicDao mechanicDao;

    @Autowired
    private GryDescDao gryDescDao;

    @Mapping(target = "artists", ignore = true)
    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "gameId", source = "id")
    public abstract JsonGraDescription mapGryToGra(Game game);

    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "recomendations", source = "playerPollResults")
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "id", source = "gameId")
    public abstract Game mapGraToGry(JsonGraDescription jsonGraDescription);

    @AfterMapping
    protected void mapGraToGry(JsonGraDescription jsonGraDescription, @MappingTarget Game gra) {
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

    }
}
