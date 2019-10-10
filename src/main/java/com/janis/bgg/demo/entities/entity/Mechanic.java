package com.janis.bgg.demo.entities.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the mechanics database table.
 */
@Entity
@Table(name = "mechanic")
@NamedQuery(name = "Mechanic.findAll", query = "SELECT m FROM Mechanic m")
public class Mechanic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    //bi-directional many-to-many association to Game
    @ManyToMany(mappedBy = "mechanics")
    private List<Game> games;

    public Mechanic(String name) {
        this.name = name;
    }


    public Mechanic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                '}';
    }
}