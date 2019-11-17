package com.janis.bgg.entities.dto;

import com.janis.bgg.entities.entity.Designer;
import com.janis.bgg.entities.entity.Mechanic;
import lombok.Data;

import java.util.Set;

@Data
public class GraDto {

    private Long gameId;
    private String name;
    private String image;
    private String thumbnail;
    private Integer minPlayers;
    private Integer maxPlayers;
    private String players;
    private Long playingTime;
    private Double averageRating;
    private Double bggRating;
    private Float price;
    private Float currentPrice;
    private Integer year;
    private Double weight;
    private Long rank;
    private Set<Designer> designers;
    private Set<Mechanic> mechanics;
    private GraDto expansion;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
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

    public Long getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Long playingTime) {
        this.playingTime = playingTime;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Double getBggRating() {
        return bggRating;
    }

    public void setBggRating(Double bggRating) {
        this.bggRating = bggRating;
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

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }
}
