
package com.janis.bgg.entities.jsonObjects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "gameId"
})
public class JsonExpansion {

    @JsonProperty("name")
    private String name;
    @JsonProperty("gameId")
    private Integer gameId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JsonExpansion() {
    }

    /**
     * @param gameId
     * @param name
     */
    public JsonExpansion(String name, Integer gameId) {
        super();
        this.name = name;
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

    @JsonProperty("gameId")
    public Integer getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
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
