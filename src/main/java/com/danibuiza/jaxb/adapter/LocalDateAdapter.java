package com.danibuiza.jaxb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * This class adapts the LocalDate objects by implementing the XmlAdapter interface in order that
 * JaxB is capable of marshal and unmarshal them
 *
 * @author dgutierrez-diez
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

}
