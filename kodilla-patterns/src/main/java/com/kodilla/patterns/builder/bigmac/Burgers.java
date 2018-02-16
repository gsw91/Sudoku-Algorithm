package com.kodilla.patterns.builder.bigmac;

public class Burgers {

    public static String SINGLE = "SINGLE";
    public static String DOUBLE = "DOUBLE";
    public static String TRIPPLE = "TRIPPLE";
    final private String burgers;

    public Burgers(String burgers) {
        if(burgers==SINGLE || burgers==DOUBLE || burgers==TRIPPLE) {
            this.burgers = burgers;
        } else {
            throw new IllegalStateException("You can choose maximum only 3 100-gram-burgers to your bigmac!");
        }
    }

    public String getBurgers() {
        return burgers;
    }

    @Override
    public String toString() {
        return "Burgers " + burgers;
    }

}
