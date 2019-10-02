
package com.janis.bgg.demo.jsonObjects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "numPlayers",
        "best",
        "recommended",
        "notRecommended",
        "numPlayersIsAndHigher"
})
public class JsonPlayerPollResult {

    @JsonProperty("numPlayers")
    private Integer numPlayers;
    @JsonProperty("best")
    private Integer best;
    @JsonProperty("recommended")
    private Integer recommended;
    @JsonProperty("notRecommended")
    private Integer notRecommended;
    @JsonProperty("numPlayersIsAndHigher")
    private Boolean numPlayersIsAndHigher;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JsonPlayerPollResult() {
    }

    /**
     * @param notRecommended
     * @param numPlayers
     * @param recommended
     * @param best
     * @param numPlayersIsAndHigher
     */
    public JsonPlayerPollResult(Integer numPlayers, Integer best, Integer recommended, Integer notRecommended, Boolean numPlayersIsAndHigher) {
        super();
        this.numPlayers = numPlayers;
        this.best = best;
        this.recommended = recommended;
        this.notRecommended = notRecommended;
        this.numPlayersIsAndHigher = numPlayersIsAndHigher;
    }

    @JsonProperty("numPlayers")
    public Integer getNumPlayers() {
        return numPlayers;
    }

    @JsonProperty("numPlayers")
    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    @JsonProperty("best")
    public Integer getBest() {
        return best;
    }

    @JsonProperty("best")
    public void setBest(Integer best) {
        this.best = best;
    }

    @JsonProperty("recommended")
    public Integer getRecommended() {
        return recommended;
    }

    @JsonProperty("recommended")
    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    @JsonProperty("notRecommended")
    public Integer getNotRecommended() {
        return notRecommended;
    }

    @JsonProperty("notRecommended")
    public void setNotRecommended(Integer notRecommended) {
        this.notRecommended = notRecommended;
    }

    @JsonProperty("numPlayersIsAndHigher")
    public Boolean getNumPlayersIsAndHigher() {
        return numPlayersIsAndHigher;
    }

    @JsonProperty("numPlayersIsAndHigher")
    public void setNumPlayersIsAndHigher(Boolean numPlayersIsAndHigher) {
        this.numPlayersIsAndHigher = numPlayersIsAndHigher;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
