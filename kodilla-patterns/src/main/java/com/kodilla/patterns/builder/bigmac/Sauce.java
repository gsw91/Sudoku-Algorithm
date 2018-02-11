package com.kodilla.patterns.builder.bigmac;

public class Sauce {

    public static String STANDARD = "STANDARD";
    public static String THOUSANDISLAND = "THOUSANDISLAND";
    public static String BARCECUE = "BARBECUE";
    final private String sauce;

    public Sauce(String sauce) {
        if (sauce.equals(STANDARD) || sauce.equals(THOUSANDISLAND) || sauce.equals(BARCECUE)) {
            this.sauce = sauce;
        } else {
            throw new IllegalStateException("You can choose sauces: STANDARD or THOUSANDISLAND or BARBECUE!");
        }
    }

    public String getSauce() {
        return sauce;
    }

    @Override
    public String toString() {
        return "Sauce " + sauce;
    }
}
