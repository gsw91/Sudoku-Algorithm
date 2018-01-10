package com.kodilla.rps.GameSystem;

public class RoundsLimit {

    public int getLimit(){

        GameInformation gameInformation = new GameInformation();

        int roundLimit = 0;

        boolean roundLimitBoolean = false;

        while (!roundLimitBoolean) {

            try {

                roundLimit = roundLimit + gameInformation.insertRoundsQuantity();

                if (roundLimit>0) {
                    roundLimitBoolean = true;
                }

            } catch (NumberFormatException e) {

                System.out.print("\n Incorrect sing, please insert a figure: \n");


            }

        }


        System.out.println("\n The game lasts for " + roundLimit + " winning rounds. Good luck! \n");

        return roundLimit;
    }
}
