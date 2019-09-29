package com.danibuiza.jaxb.museum;

import com.danibuiza.jaxb.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

/**
 * Exhibition containing a name, a date range and a list of artists the xml order is configured
 * using the XmlType annotation, the node name is defined in the name attribute of the
 * XmlRootElement or XmlElement
 *
 * @author dgutierrez-diez
 */
// field name and not xml element name
@XmlType(propOrder = {"name", "artists", "from", "to"})
@XmlRootElement(name = "EXHIBITION")
public class Exhibition {

    String name;

    LocalDate from;

    LocalDate to;

    List<String> artists;

    public String getName() {
        return name;
    }

    // name to be used in the xml
    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFrom() {
        return from;
    }

    /*
     * indicates JaxB what adapter it should use to manage this field
     */
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "FROM")
    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    /*
     * indicates JaxB what adapter it should use to manage this field
     */
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "TO")
    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<String> getArtists() {
        return artists;
    }

    @XmlElement(name = "ARTIST")
    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return getName() + "\n";
    }
}
