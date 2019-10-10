
package com.janis.bgg.demo.entities.xml.collection;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}originalname" minOccurs="0"/>
 *         &lt;element ref="{}yearpublished" minOccurs="0"/>
 *         &lt;element ref="{}image"/>
 *         &lt;element ref="{}thumbnail"/>
 *         &lt;element ref="{}status"/>
 *         &lt;element ref="{}numplays"/>
 *         &lt;element ref="{}comment" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collid" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="objectid" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="objecttype" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="subtype" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "originalname",
        "yearpublished",
        "image",
        "thumbnail",
        "status",
        "numplays",
        "comment"
})
@XmlRootElement(name = "item")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Item {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Name name;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String originalname;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer yearpublished;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String image;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String thumbnail;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Status status;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer numplays;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String comment;
    @XmlAttribute(name = "collid", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer collid;
    @XmlAttribute(name = "objectid", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Integer objectid;
    @XmlAttribute(name = "objecttype", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String objecttype;
    @XmlAttribute(name = "subtype", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String subtype;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link Name }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link Name }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the originalname property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getOriginalname() {
        return originalname;
    }

    /**
     * Sets the value of the originalname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOriginalname(String value) {
        this.originalname = value;
    }

    /**
     * Gets the value of the yearpublished property.
     *
     * @return possible object is
     * {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getYearpublished() {
        return yearpublished;
    }

    /**
     * Sets the value of the yearpublished property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setYearpublished(Integer value) {
        this.yearpublished = value;
    }

    /**
     * Gets the value of the image property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the thumbnail property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setThumbnail(String value) {
        this.thumbnail = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link Status }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link Status }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the numplays property.
     *
     * @return possible object is
     * {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getNumplays() {
        return numplays;
    }

    /**
     * Sets the value of the numplays property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNumplays(Integer value) {
        this.numplays = value;
    }

    /**
     * Gets the value of the comment property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the collid property.
     *
     * @return possible object is
     * {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getCollid() {
        return collid;
    }

    /**
     * Sets the value of the collid property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCollid(Integer value) {
        this.collid = value;
    }

    /**
     * Gets the value of the objectid property.
     *
     * @return possible object is
     * {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * Sets the value of the objectid property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setObjectid(Integer value) {
        this.objectid = value;
    }

    /**
     * Gets the value of the objecttype property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getObjecttype() {
        return objecttype;
    }

    /**
     * Sets the value of the objecttype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setObjecttype(String value) {
        this.objecttype = value;
    }

    /**
     * Gets the value of the subtype property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getSubtype() {
        return subtype;
    }

    /**
     * Sets the value of the subtype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSubtype(String value) {
        this.subtype = value;
    }

}
