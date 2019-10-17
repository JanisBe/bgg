
package com.janis.bgg.entities.xml.Items3;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{}item"/>
 *       &lt;/sequence>
 *       &lt;attribute name="termsofuse" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "item"
})
@XmlRootElement(name = "items")
public class Items {

    @XmlElement(required = true)
    protected Item item;
    @XmlAttribute(name = "termsofuse", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String termsofuse;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItem(Item value) {
        this.item = value;
    }

    /**
     * Gets the value of the termsofuse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsofuse() {
        return termsofuse;
    }

    /**
     * Sets the value of the termsofuse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsofuse(String value) {
        this.termsofuse = value;
    }

}
