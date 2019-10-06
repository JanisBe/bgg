package com.janis.bgg.demo.entity;

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
    //bi-directional many-to-many association to GraDescription
    @ManyToMany(mappedBy = "designers")
    private List<GraDescription> graDescriptions;

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

    public List<GraDescription> getGraDescriptions() {
        return this.graDescriptions;
    }

    public void setGraDescriptions(List<GraDescription> graDescriptions) {
        this.graDescriptions = graDescriptions;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "designerName='" + designerName + '\'' +
                '}';
    }
}