
package com.janis.bgg.demo.xml.Items3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.janis.bgg.demo.xml.Items3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Image_QNAME = new QName("", "image");
    private final static QName _Thumbnail_QNAME = new QName("", "thumbnail");
    private final static QName _Description_QNAME = new QName("", "description");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.janis.bgg.demo.xml.Items3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Trading }
     * 
     */
    public Trading createTrading() {
        return new Trading();
    }

    /**
     * Create an instance of {@link Average }
     * 
     */
    public Average createAverage() {
        return new Average();
    }

    /**
     * Create an instance of {@link Wanting }
     * 
     */
    public Wanting createWanting() {
        return new Wanting();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link Poll }
     * 
     */
    public Poll createPoll() {
        return new Poll();
    }

    /**
     * Create an instance of {@link Results }
     * 
     */
    public Results createResults() {
        return new Results();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Minplayers }
     * 
     */
    public Minplayers createMinplayers() {
        return new Minplayers();
    }

    /**
     * Create an instance of {@link Playingtime }
     * 
     */
    public Playingtime createPlayingtime() {
        return new Playingtime();
    }

    /**
     * Create an instance of {@link Minage }
     * 
     */
    public Minage createMinage() {
        return new Minage();
    }

    /**
     * Create an instance of {@link Ratings }
     * 
     */
    public Ratings createRatings() {
        return new Ratings();
    }

    /**
     * Create an instance of {@link Usersrated }
     * 
     */
    public Usersrated createUsersrated() {
        return new Usersrated();
    }

    /**
     * Create an instance of {@link Bayesaverage }
     * 
     */
    public Bayesaverage createBayesaverage() {
        return new Bayesaverage();
    }

    /**
     * Create an instance of {@link Ranks }
     * 
     */
    public Ranks createRanks() {
        return new Ranks();
    }

    /**
     * Create an instance of {@link Rank }
     * 
     */
    public Rank createRank() {
        return new Rank();
    }

    /**
     * Create an instance of {@link Stddev }
     * 
     */
    public Stddev createStddev() {
        return new Stddev();
    }

    /**
     * Create an instance of {@link Median }
     * 
     */
    public Median createMedian() {
        return new Median();
    }

    /**
     * Create an instance of {@link Owned }
     * 
     */
    public Owned createOwned() {
        return new Owned();
    }

    /**
     * Create an instance of {@link Wishing }
     * 
     */
    public Wishing createWishing() {
        return new Wishing();
    }

    /**
     * Create an instance of {@link Numcomments }
     * 
     */
    public Numcomments createNumcomments() {
        return new Numcomments();
    }

    /**
     * Create an instance of {@link Numweights }
     * 
     */
    public Numweights createNumweights() {
        return new Numweights();
    }

    /**
     * Create an instance of {@link Averageweight }
     * 
     */
    public Averageweight createAverageweight() {
        return new Averageweight();
    }

    /**
     * Create an instance of {@link Maxplayers }
     * 
     */
    public Maxplayers createMaxplayers() {
        return new Maxplayers();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link Yearpublished }
     * 
     */
    public Yearpublished createYearpublished() {
        return new Yearpublished();
    }

    /**
     * Create an instance of {@link Maxplaytime }
     * 
     */
    public Maxplaytime createMaxplaytime() {
        return new Maxplaytime();
    }

    /**
     * Create an instance of {@link Minplaytime }
     * 
     */
    public Minplaytime createMinplaytime() {
        return new Minplaytime();
    }

    /**
     * Create an instance of {@link Statistics }
     * 
     */
    public Statistics createStatistics() {
        return new Statistics();
    }

    /**
     * Create an instance of {@link Items }
     * 
     */
    public Items createItems() {
        return new Items();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "image")
    public JAXBElement<String> createImage(String value) {
        return new JAXBElement<String>(_Image_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "thumbnail")
    public JAXBElement<String> createThumbnail(String value) {
        return new JAXBElement<String>(_Thumbnail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

}
