package com.janis.bgg;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoNauki {
    public static void main(String[] args) throws FileNotFoundException {
        String link = "https://api.geekdo.com/xmlapi2/thing?id=213213&stats=1";
        Matcher m = Pattern.compile("^(.+id=)([0-9]+)(&.+)").matcher(link);
        m.find();
        System.out.println(m.group(2));
        PrintWriter pw = new PrintWriter("text.txt");
        pw.println("linijka2");
        pw.println("linijka2");
        pw.println("linijka2");
        pw.println("linijka2");
        pw.close();
        PrintWriter pw1 = new PrintWriter("text.txt");
        pw1.println("sdfsdf");
        pw1.println("sdfsdf");
        pw1.println("sdfsdf");
        pw1.println("sdfsdf");
        pw1.close();
    }
}
