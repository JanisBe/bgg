package com.janis.bgg.entities.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The persistent class for the game database table.
 */
@Entity
@Table(name = "game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "game_id", nullable = false)
    private int id;
    @Column(name = "bgg_rating")
    private Double bggRating;
    @Column(name = "description", length = 5000)
    private String description;
    @Column(name = "average_rating")
    private Double averageRating;
    private String image;
    @Column(name = "max_players")
    private Integer maxPlayers;
    @Column(name = "min_players")
    private Integer minPlayers;
    private String name;
    @Column(name = "playing_time")
    private int playingTime;
    private int rank;
    @Column(name = "price")
    private Double price;
    private Double weight;
    @Column(name = "year_published")
    private int yearPublished;
    // bi-directional many-to-many association to Designer
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "designers_x_gry", joinColumns = {
            @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "designers_id", referencedColumnName = "id")
    })
    private Set<Designer> designers;
    // bi-directional many-to-many association to Mechanic
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "mechanics_x_gry", joinColumns = {
            @JoinColumn(name = "gra_id", referencedColumnName = "game_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "mechanics_id", referencedColumnName = "id")
    })
    private Set<Mechanic> mechanics;
    // bi-directional many-to-one association to Recomendation
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Recomendation> recomendations;
    //    @OneToMany(mappedBy = "graDescription")
//    private Set<Recomendation> recomendation;
    private String thumbnail;
    private Integer expansionId;
/* działający przykład self-joina
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "expansion_id")
    private Game game;

    @OneToMany(mappedBy = "game")
    private Set<Game> expansion;
*/

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBggRating() {
        return this.bggRating;
    }

    public void setBggRating(Double bggRating) {
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

    public Integer getMaxPlayers() {
        return this.maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMinPlayers() {
        return this.minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
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

    public Integer getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(Integer expansionId) {
        this.expansionId = expansionId;
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

    public Set<Designer> getDesigners() {
        return this.designers;
    }

    public void setDesigners(Set<Designer> designers) {
        this.designers = designers;
    }

    public Set<Mechanic> getMechanics() {
        return this.mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public Set<Recomendation> getRecomendations() {
        return this.recomendations;
    }

    public void setRecomendations(Set<Recomendation> recomendations) {
        this.recomendations = recomendations;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Recomendation addRecomendation(Recomendation recomendation) {
        getRecomendations().add(recomendation);
        recomendation.setGame(this);

        return recomendation;
    }

    public Recomendation removeRecomendation(Recomendation recomendation) {
        getRecomendations().remove(recomendation);
        recomendation.setGame(null);

        return recomendation;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "Game{" +
                "bggRating=" + bggRating +
                ", description='" + description + '\'' +
                ", averageRating=" + averageRating +
                ", image='" + image + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", minPlayers=" + minPlayers +
                ", name='" + name + '\'' +
                ", playingTime=" + playingTime +
                ", rank=" + rank +
                ", thumbnail='" + thumbnail + '\'' +
                ", yearPublished=" + yearPublished +
                ", designers=" + designers +
                ", mechanics=" + mechanics +
                ", recomendations=" + recomendations +
                '}';
    }
}