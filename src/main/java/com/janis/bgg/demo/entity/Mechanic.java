package com.janis.bgg.demo.entity;

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
    //bi-directional many-to-many association to GraDescription
    @ManyToMany(mappedBy = "mechanics")
    private List<GraDescription> graDescriptions;

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

    public List<GraDescription> getGraDescriptions() {
        return this.graDescriptions;
    }

    public void setGraDescriptions(List<GraDescription> graDescriptions) {
        this.graDescriptions = graDescriptions;
    }

}