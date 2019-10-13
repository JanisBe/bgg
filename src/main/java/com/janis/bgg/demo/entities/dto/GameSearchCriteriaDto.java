package com.janis.bgg.demo.entities.dto;

import com.janis.bgg.demo.entities.entity.Designer;
import com.janis.bgg.demo.entities.entity.Mechanic;

import java.util.List;

public class GameSearchCriteriaDto {

    private String name;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer weight;
    private Mechanic mechanic;
    private List<Mechanic> mechanicList;
    private Designer designer;
    private List<Designer> designerList;
    private Integer playingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public List<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public void setMechanicList(List<Mechanic> mechanicList) {
        this.mechanicList = mechanicList;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public List<Designer> getDesignerList() {
        return designerList;
    }

    public void setDesignerList(List<Designer> designerList) {
        this.designerList = designerList;
    }

    public Integer getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Integer playingTime) {
        this.playingTime = playingTime;
    }
}
