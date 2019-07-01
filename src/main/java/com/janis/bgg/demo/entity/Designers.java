package com.janis.bgg.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Designers {
    private int id;
    private String designerName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "designer_name", nullable = false, length = 70)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designers designers = (Designers) o;
        return id == designers.id &&
                Objects.equals(designerName, designers.designerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designerName);
    }
}
