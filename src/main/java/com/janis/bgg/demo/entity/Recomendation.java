package com.janis.bgg.demo.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the recomendations database table.
 */
@Entity
@Table(name = "recomendations")
@NamedQuery(name = "Recomendation.findAll", query = "SELECT r FROM Recomendation r")
public class Recomendation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numPlayers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int best;
    private int notRecommended;

    public Recomendation(int best, int notRecommended, String numPlayers, int recommended, GraDescription graDescription) {
        this.best = best;
        this.notRecommended = notRecommended;
        this.numPlayers = numPlayers;
        this.recommended = recommended;
        this.graDescription = graDescription;
    }
    private int recommended;
    //bi-directional many-to-one association to GraDescription
    @ManyToOne
    @JoinColumn(name = "gra_description_game_id", referencedColumnName = "game_id")
    private GraDescription graDescription;

    public Recomendation() {
    }

    public Recomendation(int best, int notRecommended, String numPlayers, int recommended) {
        this.best = best;
        this.notRecommended = notRecommended;
        this.numPlayers = numPlayers;
        this.recommended = recommended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBest() {
        return this.best;
    }

    public void setBest(int best) {
        this.best = best;
    }

    public int getNotRecommended() {
        return this.notRecommended;
    }

    public void setNotRecommended(int notRecommended) {
        this.notRecommended = notRecommended;
    }

    public String getNumPlayers() {
        return this.numPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getRecommended() {
        return this.recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public GraDescription getGraDescription() {
        return this.graDescription;
    }

    public void setGraDescription(GraDescription graDescription) {
        this.graDescription = graDescription;
    }

    @Override
    public String toString() {
        return "Recomendation{" +
                "best=" + best +
                ", notRecommended=" + notRecommended +
                ", numPlayers='" + numPlayers + '\'' +
                ", recommended=" + recommended +
                '}';
    }
}