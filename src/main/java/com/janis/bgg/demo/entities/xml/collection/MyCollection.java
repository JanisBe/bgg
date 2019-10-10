package com.janis.bgg.demo.entities.xml.collection;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;
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
 *         &lt;element ref="{}item" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pubdate" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="termsofuse" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="totalitems" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "item"
})
@XmlRootElement(name = "items")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MyCollection {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Item> item;
    @XmlAttribute(name = "pubdate", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String pubdate;
    @XmlAttribute(name = "termsofuse", required = true)
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String termsofuse;
    @XmlAttribute(name = "totalitems", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger totalitems;

    /**
     * Gets the value of the item property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

    /**
     * Gets the value of the pubdate property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getPubdate() {
        return pubdate;
    }

    /**
     * Sets the value of the pubdate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPubdate(String value) {
        this.pubdate = value;
    }

    /**
     * Gets the value of the termsofuse property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getTermsofuse() {
        return termsofuse;
    }

    /**
     * Sets the value of the termsofuse property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTermsofuse(String value) {
        this.termsofuse = value;
    }

    /**
     * Gets the value of the totalitems property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getTotalitems() {
        return totalitems;
    }

    /**
     * Sets the value of the totalitems property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTotalitems(BigInteger value) {
        this.totalitems = value;
    }

}
