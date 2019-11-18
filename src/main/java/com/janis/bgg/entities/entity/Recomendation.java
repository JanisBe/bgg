package com.janis.bgg.entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    //bi-directional many-to-one association to Game
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    private int recommended;

    public Recomendation(int best, int notRecommended, String numPlayers, int recommended, Game game) {
        this.best = best;
        this.notRecommended = notRecommended;
        this.numPlayers = numPlayers;
        this.recommended = recommended;
        this.game = game;
    }

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

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
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
