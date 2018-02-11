package com.kodilla.patterns.builder.bigmac;

public class Roll {
    public static final String SESAME = "SESAME";
    public static final String NORMAL = "NORMAL";
    final private String roll;

    public Roll(final String roll) {
        if (roll.equals(SESAME) || roll.equals(NORMAL)) {
            this.roll = roll;
        } else {
            throw new IllegalStateException("Roll should be SESAME or NORMAL!");
        }
    }

    public String getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "Roll " + roll;
    }

}
