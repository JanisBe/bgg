package com.janis.bgg.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Grydescription {
    private int gameId;
    private String name;
    private String description;
    private String image;
    private String thumbnail;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer playingTime;
    private Integer gametypeId;
    private Integer yearPublished;
    private Double bggRating;
    private Double averageRating;
    private Integer rank;
    private List<Designers> designers;
    private List<Recomendations> recomendations;


    @Id
    @Column(name = "game_id", nullable = false)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 200)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "thumbnail", nullable = true, length = 200)
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "min_players", nullable = true)
    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    @Basic
    @Column(name = "max_players", nullable = true)
    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Basic
    @Column(name = "playing_time", nullable = true)
    public Integer getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Integer playingTime) {
        this.playingTime = playingTime;
    }

    @Basic
    @Column(name = "gametype_id", nullable = true)
    @ManyToMany(cascade = {CascadeType.REMOVE})
    @JoinTable(
            name = "gametypes",
            joinColumns = {@JoinColumn(name = "type")}
    )
    public Integer getGametypeId() {
        return gametypeId;
    }

    public void setGametypeId(Integer gametypeId) {
        this.gametypeId = gametypeId;
    }

    @Basic
    @Column(name = "year_published", nullable = true)
    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Basic
    @Column(name = "bgg_rating", nullable = true, precision = 0)
    public Double getBggRating() {
        return bggRating;
    }

    public void setBggRating(Double bggRating) {
        this.bggRating = bggRating;
    }

    @Basic
    @Column(name = "average_rating", nullable = true, precision = 0)
    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    @Basic
    @Column(name = "rank", nullable = true)
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grydescription that = (Grydescription) o;
        return gameId == that.gameId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image) &&
                Objects.equals(thumbnail, that.thumbnail) &&
                Objects.equals(minPlayers, that.minPlayers) &&
                Objects.equals(maxPlayers, that.maxPlayers) &&
                Objects.equals(playingTime, that.playingTime) &&
                Objects.equals(gametypeId, that.gametypeId) &&
                Objects.equals(yearPublished, that.yearPublished) &&
                Objects.equals(bggRating, that.bggRating) &&
                Objects.equals(averageRating, that.averageRating) &&
                Objects.equals(designers, that.designers) &&
                Objects.equals(recomendations, that.recomendations) &&
                Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, name, description, image, thumbnail, minPlayers, maxPlayers, playingTime, gametypeId, yearPublished, bggRating, averageRating, rank);
    }

    @Basic
    @OneToMany(mappedBy = "designerName")
    public List<Designers> getDesigners() {
        return designers;
    }

    public void setDesigners(List<Designers> designers) {
        this.designers = designers;
    }

    @Basic
    @OneToMany(mappedBy = "id")
    public List<Recomendations> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recomendations> recomendations) {
        this.recomendations = recomendations;
    }
}
