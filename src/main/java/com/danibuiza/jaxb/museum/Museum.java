package com.danibuiza.jaxb.museum;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Museum containing a name, a city, a permanent exhibition and a special one, these attributes are
 * going to be represented in this order in the generated XML as described in the annotation XmlType
 *
 * @author dgutierrez-diez
 */
@XmlType(propOrder = {"name", "city", "results", "permanent", "special"})
@XmlRootElement(name = "MUSEUM")
public class Museum {
    String name;
    Boolean childrenAllowed;
    Integer results;
    Exhibition special;
    Exhibition permanent;
    private String city;

    public String getName() {
        return name;
    }

    @XmlElement(name = "MUSEUM_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChildrenAllowed() {
        return childrenAllowed;
    }

    @XmlAttribute(name = "children_allowed", required = true)
    public void setChildrenAllowed(Boolean childrenAllowed) {
        this.childrenAllowed = childrenAllowed;
    }

    public Exhibition getSpecial() {
        return special;
    }

    @XmlElement(name = "SPECIAL_EXHIBITION")
    public void setSpecial(Exhibition special) {
        this.special = special;
    }

    public Exhibition getPermanent() {
        return permanent;
    }

    @XmlElement(name = "PERMANENT_EXHIBITION")
    public void setPermanent(Exhibition permanent) {
        this.permanent = permanent;
    }

    @XmlElement(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlAttribute(name = "numplayers")
    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("Name: " + getName() + "\n");
        str.append("City: " + getCity() + " max pl " + getResults() + "\n");

        if (getChildrenAllowed() != null && !getChildrenAllowed()) {
            str.append("ATTENTION! Children are not allowed in this museum\n");

        }
        if (getPermanent() != null) {
            str.append(getPermanent().toString());
        }
        if (getSpecial() != null) {
            str.append(getSpecial().toString());
        }
        str.append("\n");

        return str.toString();
    }

}
