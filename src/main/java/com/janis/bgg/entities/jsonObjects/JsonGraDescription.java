
package com.janis.bgg.entities.jsonObjects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "gameId",
        "name",
        "description",
        "image",
        "thumbnail",
        "minPlayers",
        "maxPlayers",
        "playingTime",
        "mechanics",
        "isExpansion",
        "yearPublished",
        "bggRating",
        "averageRating",
        "rank",
        "designers",
        "publishers",
        "artists",
        "playerPollResults",
        "jsonExpansions",
        "expands"
})
public class JsonGraDescription {

    @JsonProperty("gameId")
    private Integer gameId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("image")
    private String image;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("minPlayers")
    private Integer minPlayers;
    @JsonProperty("maxPlayers")
    private Integer maxPlayers;
    @JsonProperty("playingTime")
    private Integer playingTime;
    @JsonProperty("mechanics")
    private List<String> mechanics = null;
    @JsonProperty("isExpansion")
    private Boolean isExpansion;
    @JsonProperty("yearPublished")
    private Integer yearPublished;
    @JsonProperty("bggRating")
    private Double bggRating;
    @JsonProperty("averageRating")
    private Double averageRating;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("designers")
    private List<String> designers = null;
    @JsonProperty("publishers")
    private List<String> publishers = null;
    @JsonProperty("artists")
    private List<String> artists = null;
    @JsonProperty("playerPollResults")
    private List<JsonPlayerPollResult> playerPollResults = null;
    @JsonProperty("jsonExpansions")
    private List<JsonExpansion> jsonExpansions = null;
    @JsonProperty("expands")
    private List<JsonExpansion> expands = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public JsonGraDescription() {
    }

    /**
     * @param publishers
     * @param averageRating
     * @param maxPlayers
     * @param gameId
     * @param minPlayers
     * @param yearPublished
     * @param image
     * @param jsonExpansions
     * @param playerPollResults
     * @param artists
     * @param bggRating
     * @param rank
     * @param thumbnail
     * @param description
     * @param playingTime
     * @param designers
     * @param name
     * @param mechanics
     * @param isExpansion
     */
    public JsonGraDescription(Integer gameId, String name, String description, String image, String thumbnail, Integer minPlayers, Integer maxPlayers, Integer playingTime, List<String> mechanics, Boolean isExpansion, Integer yearPublished, Double bggRating, Double averageRating, Integer rank, List<String> designers, List<String> publishers, List<String> artists, List<JsonPlayerPollResult> playerPollResults, List<JsonExpansion> jsonExpansions, List<JsonExpansion> expands) {
        super();
        this.gameId = gameId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.thumbnail = thumbnail;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
        this.mechanics = mechanics;
        this.isExpansion = isExpansion;
        this.yearPublished = yearPublished;
        this.bggRating = bggRating;
        this.averageRating = averageRating;
        this.rank = rank;
        this.designers = designers;
        this.publishers = publishers;
        this.artists = artists;
        this.playerPollResults = playerPollResults;
        this.jsonExpansions = jsonExpansions;
        this.expands = expands;
    }

    @JsonProperty("gameId")
    public Integer getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("minPlayers")
    public Integer getMinPlayers() {
        return minPlayers;
    }

    @JsonProperty("minPlayers")
    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    @JsonProperty("maxPlayers")
    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    @JsonProperty("maxPlayers")
    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @JsonProperty("playingTime")
    public Integer getPlayingTime() {
        return playingTime;
    }

    @JsonProperty("playingTime")
    public void setPlayingTime(Integer playingTime) {
        this.playingTime = playingTime;
    }

    @JsonProperty("mechanics")
    public List<String> getMechanics() {
        return mechanics;
    }

    @JsonProperty("mechanics")
    public void setMechanics(List<String> mechanics) {
        this.mechanics = mechanics;
    }

    @JsonProperty("isExpansion")
    public Boolean getIsExpansion() {
        return isExpansion;
    }

    @JsonProperty("isExpansion")
    public void setIsExpansion(Boolean isExpansion) {
        this.isExpansion = isExpansion;
    }

    @JsonProperty("yearPublished")
    public Integer getYearPublished() {
        return yearPublished;
    }

    @JsonProperty("yearPublished")
    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    @JsonProperty("bggRating")
    public Double getBggRating() {
        return bggRating;
    }

    @JsonProperty("bggRating")
    public void setBggRating(Double bggRating) {
        this.bggRating = bggRating;
    }

    @JsonProperty("averageRating")
    public Double getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("designers")
    public List<String> getDesigners() {
        return designers;
    }

    @JsonProperty("designers")
    public void setDesigners(List<String> designers) {
        this.designers = designers;
    }

    @JsonProperty("publishers")
    public List<String> getPublishers() {
        return publishers;
    }

    @JsonProperty("publishers")
    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    @JsonProperty("artists")
    public List<String> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    @JsonProperty("playerPollResults")
    public List<JsonPlayerPollResult> getPlayerPollResults() {
        return playerPollResults;
    }

    @JsonProperty("playerPollResults")
    public void setPlayerPollResults(List<JsonPlayerPollResult> playerPollResults) {
        this.playerPollResults = playerPollResults;
    }

    @JsonProperty("jsonExpansions")
    public List<JsonExpansion> getJsonExpansions() {
        return jsonExpansions;
    }

    @JsonProperty("jsonExpansions")
    public void setJsonExpansions(List<JsonExpansion> jsonExpansions) {
        this.jsonExpansions = jsonExpansions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("expands")
    public List<JsonExpansion> getExpands() {
        return expands;
    }

    @JsonProperty("expands")
    public void setExpands(List<JsonExpansion> expands) {
        this.expands = expands;
    }



}
