package com.janis.bgg.demo.entities.dto;

import com.janis.bgg.demo.entities.entity.Designer;
import com.janis.bgg.demo.entities.entity.Mechanic;
import lombok.Data;

import java.util.Set;

@Data
public class GraDto {

    private long gameId;
    private String name;
    private String image;
    private String thumbnail;
    private Integer minPlayers;
    private Integer maxPlayers;
    private String players;
    private long playingTime;
    private double averageRating;
    private double bggRating;
    private Integer price;
    private Integer year;
    private Double weight;
    private long rank;
    private Set<Designer> designers;
    private Set<Mechanic> mechanics;
    private GraDto expansion;
    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(long playingTime) {
        this.playingTime = playingTime;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public double getBggRating() {
        return bggRating;
    }

    public void setBggRating(double bggRating) {
        this.bggRating = bggRating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Designer> getDesigners() {
        return designers;
    }

    public void setDesigners(Set<Designer> designers) {
        this.designers = designers;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public GraDto getExpansion() {
        return expansion;
    }

    public void setExpansion(GraDto expansion) {
        this.expansion = expansion;
    }
}
