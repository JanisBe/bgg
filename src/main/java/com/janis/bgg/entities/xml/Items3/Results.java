
package com.janis.bgg.entities.xml.Items3;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}result" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numplayers" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result"
})
@XmlRootElement(name = "results")
public class Results {

    @XmlElement(required = true)
    protected List<Result> result;
    @XmlAttribute(name = "numplayers")
    @XmlSchemaType(name = "anySimpleType")
    protected String numplayers;

    /**
     * Gets the value of the result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Result }
     * 
     * 
     */
    public List<Result> getResult() {
        if (result == null) {
            result = new ArrayList<Result>();
        }
        return this.result;
    }

    /**
     * Gets the value of the numplayers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumplayers() {
        return numplayers;
    }

    /**
     * Sets the value of the numplayers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumplayers(String value) {
        this.numplayers = value;
    }

}
