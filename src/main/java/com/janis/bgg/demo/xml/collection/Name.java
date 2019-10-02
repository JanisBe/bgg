
package com.janis.bgg.demo.xml.collection;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="sortindex" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "name")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Name {

    @XmlValue
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String content;
    @XmlAttribute(name = "sortindex", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger sortindex;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the sortindex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getSortindex() {
        return sortindex;
    }

    /**
     * Sets the value of the sortindex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-02T10:08:36+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSortindex(BigInteger value) {
        this.sortindex = value;
    }

}
