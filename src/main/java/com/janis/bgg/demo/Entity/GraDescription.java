package com.janis.bgg.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the gra_description database table.
 */
@Entity
@Table(name = "gra_description")
@NamedQuery(name = "GraDescription.findAll", query = "SELECT g FROM GraDescription g")
public class GraDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id", nullable = false)
    private int id;
    @Column(name = "bgg_rating")
    private float bggRating;
    @Column(name = "description", length = 3000)
    private String description;
    @Column(name = "average_rating", nullable = true, precision = 0)
    private Double averageRating;
    private String image;
    @Column(name = "max_players")
    private int maxPlayers;
    @Column(name = "min_players")
    private int minPlayers;
    private String name;
    @Column(name = "playing_time")
    private int playingTime;
    private int rank;
    @OneToMany(mappedBy = "graDescription")
    private List<Recomendation> recomendation;
    private String thumbnail;
    @Column(name = "year_published")
    private int yearPublished;
    //bi-directional many-to-many association to Designer
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "designers_x_gry", joinColumns = {
            @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "designers_id", referencedColumnName = "id")
    }
    )
    private List<Designer> designers;
    //bi-directional many-to-many association to Mechanic
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "mechanics_x_gry", joinColumns = {
            @JoinColumn(name = "gra_id", referencedColumnName = "game_id")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "mechanics_id", referencedColumnName = "id")
    }
    )
    private List<Mechanic> mechanics;
    //bi-directional many-to-one association to Recomendation
    @OneToMany(mappedBy = "graDescription", cascade = CascadeType.ALL)
    private List<Recomendation> recomendations;

    public GraDescription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBggRating() {
        return this.bggRating;
    }

    public void setBggRating(float bggRating) {
        this.bggRating = bggRating;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return this.minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayingTime() {
        return this.playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<Recomendation> getRecomendation() {
        return this.recomendation;
    }

    public void setRecomendation(List<Recomendation> recomendationId) {
        this.recomendation = recomendationId;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public List<Designer> getDesigners() {
        return this.designers;
    }

    public void setDesigners(List<Designer> designers) {
        this.designers = designers;
    }

    public List<Mechanic> getMechanics() {
        return this.mechanics;
    }

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public List<Recomendation> getRecomendations() {
        return this.recomendations;
    }

    public void setRecomendations(List<Recomendation> recomendations) {
        this.recomendations = recomendations;
    }

    public Recomendation addRecomendation(Recomendation recomendation) {
        getRecomendations().add(recomendation);
        recomendation.setGraDescription(this);

        return recomendation;
    }

    public Recomendation removeRecomendation(Recomendation recomendation) {
        getRecomendations().remove(recomendation);
        recomendation.setGraDescription(null);

        return recomendation;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}