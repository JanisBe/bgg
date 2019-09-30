package com.danibuiza.jaxb.museum;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "results")
public class Results {
    private Integer numplayers;

    public Integer getNumplayers() {
        return numplayers;
    }

    @XmlAttribute
    public void setNumplayers(Integer numplayers) {
        this.numplayers = numplayers;
    }

    @Override
    public String toString() {
        return "ClassPojo [numplayers = " + numplayers + "]";
    }
}

