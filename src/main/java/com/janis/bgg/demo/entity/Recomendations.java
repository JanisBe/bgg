package com.janis.bgg.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Recomendations {
    private int id;
    private int numPlayers;
    private int best;
    private int recommended;
    private int notRecommended;

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numPlayers", nullable = false)
    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    @Basic
    @Column(name = "best", nullable = false)
    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }

    @Basic
    @Column(name = "recommended", nullable = false)
    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    @Basic
    @Column(name = "notRecommended", nullable = false)
    public int getNotRecommended() {
        return notRecommended;
    }

    public void setNotRecommended(int notRecommended) {
        this.notRecommended = notRecommended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recomendations that = (Recomendations) o;
        return id == that.id &&
                numPlayers == that.numPlayers &&
                best == that.best &&
                recommended == that.recommended &&
                notRecommended == that.notRecommended;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numPlayers, best, recommended, notRecommended);
    }
}
