package com.janis.bgg.entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the designers database table.
 */
@Entity
@Table(name = "designers")
@NamedQuery(name = "Designer.findAll", query = "SELECT d FROM Designer d")
public class Designer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "designer_name")
    private String designerName;
    //bi-directional many-to-many association to Game
    @ManyToMany(mappedBy = "designers")
    @JsonIgnore
    private List<Game> games;

    public Designer(String designerName) {
        this.designerName = designerName;
    }

    public Designer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignerName() {
        return this.designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "designerName='" + designerName + '\'' +
                '}';
    }
}
