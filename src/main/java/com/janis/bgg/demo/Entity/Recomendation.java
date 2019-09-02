package com.janis.bgg.demo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the recomendations database table.
 */
@Entity
@Table(name = "recomendations")
@NamedQuery(name = "Recomendation.findAll", query = "SELECT r FROM Recomendation r")
public class Recomendation implements Serializable {
    private static final long serialVersionUID = 1L;

    public Recomendation(int best, int notRecommended, int numPlayers, int recommended, GraDescription graDescription) {
        this.best = best;
        this.notRecommended = notRecommended;
        this.numPlayers = numPlayers;
        this.recommended = recommended;
        this.graDescription = graDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int best;
    private int notRecommended;
    private int numPlayers;
    private int recommended;
    //bi-directional many-to-one association to GraDescription
    @ManyToOne
    @JoinColumn(name = "gra_description_game_id", referencedColumnName = "game_id")
    private GraDescription graDescription;

    public Recomendation() {
    }

    public Recomendation(int best, int notRecommended, int numPlayers, int recommended) {
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

    public int getNumPlayers() {
        return this.numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
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

}