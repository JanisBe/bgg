package com.janis.bgg.demo.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.janis.bgg.demo.Entity.Designer;
import com.janis.bgg.demo.Entity.GraDescription;
import com.janis.bgg.demo.Entity.Mechanic;
import com.janis.bgg.demo.JsonObjects.JsonGraDescription;

@Mapper(componentModel = "spring")

public abstract class GraDescriptionMapper {

    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "gameId", source = "id")
    public abstract JsonGraDescription mapGryToGra(GraDescription graDescription);

    @Mapping(target = "mechanics", ignore = true)
    @Mapping(target = "recomendations", source = "playerPollResults")
    @Mapping(target = "designers", ignore = true)
    @Mapping(target = "recomendation", ignore = true)
    @Mapping(target = "id", source = "gameId")
    public abstract GraDescription mapGraToGry(JsonGraDescription jsonGraDescription);

//    @Mapping
//    public Mechanics mapMechanics(String mechanics){
//        return new Mechanics(mechanics);
//    }

    @AfterMapping
    protected void mapuj(JsonGraDescription jsonGraDescription, @MappingTarget GraDescription gra) {

        Set<Mechanic> listaMechanik = jsonGraDescription.getMechanics().stream().map(that -> new Mechanic(that)).collect(Collectors.toSet());
        gra.setMechanics(listaMechanik);
        Set<Designer> listaDesignerow = jsonGraDescription.getDesigners().stream().map(that -> new Designer(that)).collect(Collectors.toSet());
        gra.setDesigners(listaDesignerow);

    }
}
