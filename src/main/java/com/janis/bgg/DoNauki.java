package com.janis.bgg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoNauki {
    public static void main(String[] args) {
        String link = "2-5";
        String link2 = "2";
        Matcher m = Pattern.compile("(\\d)\\s?-\\s?(\\d)").matcher(link);
        m.find();
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        String[] asd = link.split("\\s?-\\s?");
        String[] asd2 = link2.split("\\s?-\\s?");
        System.out.println(asd[0] + " " + asd[1]);
        System.out.println(asd2[0]);
    }
}
