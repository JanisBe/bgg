
package com.janis.bgg.entities.xml.items;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
 *       &lt;sequence>
 *         &lt;element ref="{}thumbnail"/>
 *         &lt;element ref="{}image"/>
 *         &lt;element ref="{}name" maxOccurs="unbounded"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}yearpublished"/>
 *         &lt;element ref="{}minplayers"/>
 *         &lt;element ref="{}maxplayers"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}maxplaytime"/>
 *           &lt;element ref="{}minage"/>
 *           &lt;element ref="{}minplaytime"/>
 *           &lt;element ref="{}playingtime"/>
 *           &lt;element ref="{}poll"/>
 *         &lt;/choice>
 *         &lt;element ref="{}link" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "thumbnail",
        "image",
        "name",
        "description",
        "yearpublished",
        "minplayers",
        "maxplayers",
        "maxplaytimeOrMinageOrMinplaytime",
        "link"
})
@XmlRootElement(name = "item")
public class Item {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String thumbnail;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String image;
    @XmlElement(required = true)
    protected List<Name> name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Yearpublished yearpublished;
    @XmlElement(required = true)
    protected Players minplayers;
    @XmlElement(required = true)
    protected Players maxplayers;
    @XmlElements({
            @XmlElement(name = "maxplaytime", type = Playtime.class),
            @XmlElement(name = "minage", type = Minage.class),
            @XmlElement(name = "minplaytime", type = Playtime.class),
            @XmlElement(name = "playingtime", type = Playingtime.class),
            @XmlElement(name = "poll", type = Poll.class)
    })
    protected List<Object> maxplaytimeOrMinageOrMinplaytime;
    @XmlElement(required = true)
    protected List<Link> link;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String type;

    /**
     * Gets the value of the thumbnail property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     * 
     * @param value
     *            allowed object is
     *            {@link String }
     * 
     */
    public void setThumbnail(String value) {
        this.thumbnail = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *            allowed object is
     *            {@link String }
     * 
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getName() {
        if (name == null) {
            name = new ArrayList<>();
        }
        return this.name;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *            allowed object is
     *            {@link String }
     * 
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the yearpublished property.
     * 
     * @return
     *         possible object is
     *         {@link Yearpublished }
     * 
     */
    public Yearpublished getYearpublished() {
        return yearpublished;
    }

    /**
     * Sets the value of the yearpublished property.
     * 
     * @param value
     *            allowed object is
     *            {@link Yearpublished }
     * 
     */
    public void setYearpublished(Yearpublished value) {
        this.yearpublished = value;
    }

    /**
     * Gets the value of the minplayers property.
     * 
     * @return
     *         possible object is
     *         {@link Minplayers }
     * 
     */
    public Players getMinplayers() {
        return minplayers;
    }

    /**
     * Sets the value of the minplayers property.
     * 
     * @param value
     *            allowed object is
     *            {@link Players }
     * 
     */
    public void setMinplayers(Players value) {
        this.minplayers = value;
    }

    /**
     * Gets the value of the maxplayers property.
     * 
     * @return
     *         possible object is
     *         {@link Players }
     * 
     */
    public Players getMaxplayers() {
        return maxplayers;
    }

    /**
     * Sets the value of the maxplayers property.
     * 
     * @param value
     *            allowed object is
     *            {@link Players }
     * 
     */
    public void setMaxplayers(Players value) {
        this.maxplayers = value;
    }

    /**
     * Gets the value of the maxplaytimeOrMinageOrMinplaytime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maxplaytimeOrMinageOrMinplaytime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getMaxplaytimeOrMinageOrMinplaytime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Maxplaytime }
     * {@link Minage }
     * {@link Playtime }
     * {@link Playingtime }
     * {@link Poll }
     * 
     * 
     */
    public List<Object> getMaxplaytimeOrMinageOrMinplaytime() {
        if (maxplaytimeOrMinageOrMinplaytime == null) {
            maxplaytimeOrMinageOrMinplaytime = new ArrayList<>();
        }
        return this.maxplaytimeOrMinageOrMinplaytime;
    }

    /**
     * Gets the value of the link property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the link property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     * 
     * 
     */
    public List<Link> getLink() {
        if (link == null) {
            link = new ArrayList<>();
        }
        return this.link;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *         possible object is
     *         {@link BigInteger }
     * 
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *            allowed object is
     *            {@link BigInteger }
     * 
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *            allowed object is
     *            {@link String }
     * 
     */
    public void setType(String value) {
        this.type = value;
    }

}
