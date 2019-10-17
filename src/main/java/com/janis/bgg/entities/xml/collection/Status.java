
package com.janis.bgg.entities.xml.collection;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="fortrade" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="lastmodified" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="own" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="preordered" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="prevowned" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="want" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wanttobuy" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wanttoplay" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wishlist" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "status")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Status {

    @XmlAttribute(name = "fortrade", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger fortrade;
    @XmlAttribute(name = "lastmodified", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String lastmodified;
    @XmlAttribute(name = "own", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger own;
    @XmlAttribute(name = "preordered", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger preordered;
    @XmlAttribute(name = "prevowned", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger prevowned;
    @XmlAttribute(name = "want", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger want;
    @XmlAttribute(name = "wanttobuy", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger wanttobuy;
    @XmlAttribute(name = "wanttoplay", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger wanttoplay;
    @XmlAttribute(name = "wishlist", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger wishlist;

    /**
     * Gets the value of the fortrade property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getFortrade() {
        return fortrade;
    }

    /**
     * Sets the value of the fortrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFortrade(BigInteger value) {
        this.fortrade = value;
    }

    /**
     * Gets the value of the lastmodified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLastmodified() {
        return lastmodified;
    }

    /**
     * Sets the value of the lastmodified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLastmodified(String value) {
        this.lastmodified = value;
    }

    /**
     * Gets the value of the own property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getOwn() {
        return own;
    }

    /**
     * Sets the value of the own property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOwn(BigInteger value) {
        this.own = value;
    }

    /**
     * Gets the value of the preordered property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getPreordered() {
        return preordered;
    }

    /**
     * Sets the value of the preordered property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPreordered(BigInteger value) {
        this.preordered = value;
    }

    /**
     * Gets the value of the prevowned property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getPrevowned() {
        return prevowned;
    }

    /**
     * Sets the value of the prevowned property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPrevowned(BigInteger value) {
        this.prevowned = value;
    }

    /**
     * Gets the value of the want property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getWant() {
        return want;
    }

    /**
     * Sets the value of the want property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWant(BigInteger value) {
        this.want = value;
    }

    /**
     * Gets the value of the wanttobuy property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getWanttobuy() {
        return wanttobuy;
    }

    /**
     * Sets the value of the wanttobuy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWanttobuy(BigInteger value) {
        this.wanttobuy = value;
    }

    /**
     * Gets the value of the wanttoplay property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getWanttoplay() {
        return wanttoplay;
    }

    /**
     * Sets the value of the wanttoplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWanttoplay(BigInteger value) {
        this.wanttoplay = value;
    }

    /**
     * Gets the value of the wishlist property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getWishlist() {
        return wishlist;
    }

    /**
     * Sets the value of the wishlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWishlist(BigInteger value) {
        this.wishlist = value;
    }

}
