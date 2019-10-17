package com.janis.bgg.entities.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gry2")
public class Gra implements Comparable<Gra> {
    private int gameId;
    private String name;
    private String image;
    private String thumbnail;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer playingTime;
    private Integer yearPublished;
    private Double bggRating;
    private Double averageRating;
    private Integer rank;
    private Integer numPlays;
    private Double rating;
    private String userComment;
    private Integer expansionId;

    @Id
    @Column(name = "game_id", nullable = false)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 55)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 89)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "thumbnail", nullable = true, length = 97)
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

    @Basic
    @Column(name = "num_plays", nullable = true)
    public Integer getNumPlays() {
        return numPlays;
    }

    public void setNumPlays(Integer numPlays) {
        this.numPlays = numPlays;
    }

    @Basic
    @Column(name = "rating", nullable = true, precision = 0)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "user_comment", nullable = true, length = 9)
    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    @Basic
    @Column(name = "expansion_id", nullable = true)
    public Integer getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(Integer expansionId) {
        this.expansionId = expansionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gra gry2 = (Gra) o;
        return gameId == gry2.gameId &&
                Objects.equals(name, gry2.name) &&
                Objects.equals(image, gry2.image) &&
                Objects.equals(thumbnail, gry2.thumbnail) &&
                Objects.equals(minPlayers, gry2.minPlayers) &&
                Objects.equals(maxPlayers, gry2.maxPlayers) &&
                Objects.equals(playingTime, gry2.playingTime) &&
                Objects.equals(yearPublished, gry2.yearPublished) &&
                Objects.equals(bggRating, gry2.bggRating) &&
                Objects.equals(averageRating, gry2.averageRating) &&
                Objects.equals(rank, gry2.rank) &&
                Objects.equals(numPlays, gry2.numPlays) &&
                Objects.equals(rating, gry2.rating) &&
                Objects.equals(userComment, gry2.userComment) &&
                Objects.equals(expansionId, gry2.expansionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, name, image, thumbnail, minPlayers, maxPlayers, playingTime, yearPublished, bggRating, averageRating, rank, numPlays, rating, userComment, expansionId);
    }

    @Override
    public int compareTo(Gra o) {
        return name.compareTo(o.getName());
    }
}
