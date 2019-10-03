
package com.janis.bgg.demo.xml.items;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="numvotes" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "result")
public class Result {

    @XmlAttribute(name = "level")
    protected Integer level;
    @XmlAttribute(name = "numvotes", required = true)
    protected Integer numvotes;
    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String value;

    /**
     * Gets the value of the level property.
     * 
     * @return
     *         possible object is
     *         {@link Integer }
     * 
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *            allowed object is
     *            {@link Integer }
     * 
     */
    public void setLevel(Integer value) {
        this.level = value;
    }

    /**
     * Gets the value of the numvotes property.
     * 
     * @return
     *         possible object is
     *         {@link Integer }
     * 
     */
    public Integer getNumvotes() {
        return numvotes;
    }

    /**
     * Sets the value of the numvotes property.
     * 
     * @param value
     *            allowed object is
     *            {@link Integer }
     * 
     */
    public void setNumvotes(Integer value) {
        this.numvotes = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *            allowed object is
     *            {@link String }
     * 
     */
    public void setValue(String value) {
        this.value = value;
    }

}
