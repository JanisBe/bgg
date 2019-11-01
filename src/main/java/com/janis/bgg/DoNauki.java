package com.janis.bgg;

public class DoNauki {
    public static void main(String[] args) {
        System.out.println(new StringBuilder().length());
        float wynik = Dzielenie.dziel(8, 0);
        System.out.println(wynik);
    }

    private static class Dzielenie {
        public static float dziel(int a, int b) {
            float res = 0;
            try {
                res = a / b;
            } catch (Exception e) {

                System.out.println(a + "," + b);
            }
            return res;
        }

    }
}
