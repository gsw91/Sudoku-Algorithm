package com.kodilla.rps.GameSystem;


import java.util.Scanner;


public class EndOfGame {


    public void endingGame() {

        GameInformation gameInformation = new GameInformation();
        Scanner scanner = new Scanner(System.in);

        boolean isThisEnd = false;

        if (!isThisEnd) {

            System.out.println("\n Game is finished. Put n to play one more time, or x key to exit");

            try {

                gameInformation.exitOrReset(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please, confirm your decision");

            }
        }
    }


}
