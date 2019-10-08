package com.janis.bgg.demo;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class DoNauki {
    public static void main(String[] args) {
        List<String> bgg = Lists.newArrayList();
        bgg.add("1");
        bgg.add("2");
        bgg.add("3");
        bgg.add("4");
        bgg.add("5");

        List<String> local = Arrays.asList("2", "4", "5");
        boolean x = bgg.removeAll(local);
        System.out.println(x);
    }
}
