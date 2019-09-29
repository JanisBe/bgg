package com.danibuiza.jaxb.museum;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * JaxB is not capable of marshal lists directly as root elements, so we need a container for the
 * list of museums. Getter and Setter are used by jaxb
 *
 * @author dgutierrez-diez
 */
@XmlRootElement(name = "MUSEUMS")
public class Museums {
    List<Museum> museums;

    public List<Museum> getMuseums() {
        return museums;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement(name = "MUSEUM")
    public void setMuseums(List<Museum> museums) {
        this.museums = museums;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     *
     * @param museum
     */
    public void add(Museum museum) {
        if (this.museums == null) {
            this.museums = new ArrayList<Museum>();
        }
        this.museums.add(museum);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Museum museum : this.museums) {
            str.append(museum.toString());
        }
        return str.toString();
    }

}
