
package com.janis.bgg.demo.entities.xml.Items3;

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
 *         &lt;element ref="{}usersrated"/>
 *         &lt;element ref="{}average"/>
 *         &lt;element ref="{}bayesaverage"/>
 *         &lt;element ref="{}ranks"/>
 *         &lt;element ref="{}stddev"/>
 *         &lt;element ref="{}median"/>
 *         &lt;element ref="{}owned"/>
 *         &lt;element ref="{}trading"/>
 *         &lt;element ref="{}wanting"/>
 *         &lt;element ref="{}wishing"/>
 *         &lt;element ref="{}numcomments"/>
 *         &lt;element ref="{}numweights"/>
 *         &lt;element ref="{}averageweight"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usersrated",
    "average",
    "bayesaverage",
    "ranks",
    "stddev",
    "median",
    "owned",
    "trading",
    "wanting",
    "wishing",
    "numcomments",
    "numweights",
    "averageweight"
})
@XmlRootElement(name = "ratings")
public class Ratings {

    @XmlElement(required = true)
    protected Usersrated usersrated;
    @XmlElement(required = true)
    protected Average average;
    @XmlElement(required = true)
    protected Bayesaverage bayesaverage;
    @XmlElement(required = true)
    protected Ranks ranks;
    @XmlElement(required = true)
    protected Stddev stddev;
    @XmlElement(required = true)
    protected Median median;
    @XmlElement(required = true)
    protected Owned owned;
    @XmlElement(required = true)
    protected Trading trading;
    @XmlElement(required = true)
    protected Wanting wanting;
    @XmlElement(required = true)
    protected Wishing wishing;
    @XmlElement(required = true)
    protected Numcomments numcomments;
    @XmlElement(required = true)
    protected Numweights numweights;
    @XmlElement(required = true)
    protected Averageweight averageweight;

    /**
     * Gets the value of the usersrated property.
     * 
     * @return
     *     possible object is
     *     {@link Usersrated }
     *     
     */
    public Usersrated getUsersrated() {
        return usersrated;
    }

    /**
     * Sets the value of the usersrated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usersrated }
     *     
     */
    public void setUsersrated(Usersrated value) {
        this.usersrated = value;
    }

    /**
     * Gets the value of the average property.
     * 
     * @return
     *     possible object is
     *     {@link Average }
     *     
     */
    public Average getAverage() {
        return average;
    }

    /**
     * Sets the value of the average property.
     * 
     * @param value
     *     allowed object is
     *     {@link Average }
     *     
     */
    public void setAverage(Average value) {
        this.average = value;
    }

    /**
     * Gets the value of the bayesaverage property.
     * 
     * @return
     *     possible object is
     *     {@link Bayesaverage }
     *     
     */
    public Bayesaverage getBayesaverage() {
        return bayesaverage;
    }

    /**
     * Sets the value of the bayesaverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bayesaverage }
     *     
     */
    public void setBayesaverage(Bayesaverage value) {
        this.bayesaverage = value;
    }

    /**
     * Gets the value of the ranks property.
     * 
     * @return
     *     possible object is
     *     {@link Ranks }
     *     
     */
    public Ranks getRanks() {
        return ranks;
    }

    /**
     * Sets the value of the ranks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ranks }
     *     
     */
    public void setRanks(Ranks value) {
        this.ranks = value;
    }

    /**
     * Gets the value of the stddev property.
     * 
     * @return
     *     possible object is
     *     {@link Stddev }
     *     
     */
    public Stddev getStddev() {
        return stddev;
    }

    /**
     * Sets the value of the stddev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stddev }
     *     
     */
    public void setStddev(Stddev value) {
        this.stddev = value;
    }

    /**
     * Gets the value of the median property.
     * 
     * @return
     *     possible object is
     *     {@link Median }
     *     
     */
    public Median getMedian() {
        return median;
    }

    /**
     * Sets the value of the median property.
     * 
     * @param value
     *     allowed object is
     *     {@link Median }
     *     
     */
    public void setMedian(Median value) {
        this.median = value;
    }

    /**
     * Gets the value of the owned property.
     * 
     * @return
     *     possible object is
     *     {@link Owned }
     *     
     */
    public Owned getOwned() {
        return owned;
    }

    /**
     * Sets the value of the owned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Owned }
     *     
     */
    public void setOwned(Owned value) {
        this.owned = value;
    }

    /**
     * Gets the value of the trading property.
     * 
     * @return
     *     possible object is
     *     {@link Trading }
     *     
     */
    public Trading getTrading() {
        return trading;
    }

    /**
     * Sets the value of the trading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trading }
     *     
     */
    public void setTrading(Trading value) {
        this.trading = value;
    }

    /**
     * Gets the value of the wanting property.
     * 
     * @return
     *     possible object is
     *     {@link Wanting }
     *     
     */
    public Wanting getWanting() {
        return wanting;
    }

    /**
     * Sets the value of the wanting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wanting }
     *     
     */
    public void setWanting(Wanting value) {
        this.wanting = value;
    }

    /**
     * Gets the value of the wishing property.
     * 
     * @return
     *     possible object is
     *     {@link Wishing }
     *     
     */
    public Wishing getWishing() {
        return wishing;
    }

    /**
     * Sets the value of the wishing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wishing }
     *     
     */
    public void setWishing(Wishing value) {
        this.wishing = value;
    }

    /**
     * Gets the value of the numcomments property.
     * 
     * @return
     *     possible object is
     *     {@link Numcomments }
     *     
     */
    public Numcomments getNumcomments() {
        return numcomments;
    }

    /**
     * Sets the value of the numcomments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numcomments }
     *     
     */
    public void setNumcomments(Numcomments value) {
        this.numcomments = value;
    }

    /**
     * Gets the value of the numweights property.
     * 
     * @return
     *     possible object is
     *     {@link Numweights }
     *     
     */
    public Numweights getNumweights() {
        return numweights;
    }

    /**
     * Sets the value of the numweights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numweights }
     *     
     */
    public void setNumweights(Numweights value) {
        this.numweights = value;
    }

    /**
     * Gets the value of the averageweight property.
     * 
     * @return
     *     possible object is
     *     {@link Averageweight }
     *     
     */
    public Averageweight getAverageweight() {
        return averageweight;
    }

    /**
     * Sets the value of the averageweight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Averageweight }
     *     
     */
    public void setAverageweight(Averageweight value) {
        this.averageweight = value;
    }

}
