package com.janis.bgg.entities.jsonObjects;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "designers"
})
public class JsonDesigner {

    @JsonProperty("designers")
    @Valid
    public List<String> designers = new ArrayList<String>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JsonDesigner() {
    }

    /**
     * @param designers
     */
    public JsonDesigner(List<String> designers) {
        super();
        this.designers = designers;
    }

    public JsonDesigner withDesigners(List<String> designers) {
        this.designers = designers;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public JsonDesigner withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}