package com.janis.bgg.demo.XMLObjects.Adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerXmlAdapter extends XmlAdapter<String, Integer> {
    private static final Logger LOG = LoggerFactory.getLogger(IntegerXmlAdapter.class);

    @Override
    public Integer unmarshal(final String v) {
        Integer result = null;

        try {
            result = Integer.valueOf(v);
        } catch (NumberFormatException e) {
            LOG.debug(e.getMessage(), e);
        }

        return result;
    }

    @Override
    public String marshal(final Integer v) {
        return String.valueOf(v);
    }
}
