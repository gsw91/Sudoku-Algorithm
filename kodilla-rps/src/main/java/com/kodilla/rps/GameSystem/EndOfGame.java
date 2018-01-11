package com.kodilla.rps.GameSystem;


import java.util.Scanner;


public class EndOfGame {


    public void endingGame() {

        GameInformation gameInformation = new GameInformation();
        System.out.println("\n Game is finished. Put n to play one more time, or x to exit");

        Scanner scanner = new Scanner(System.in);

        try {

            gameInformation.exitOrReset(scanner.nextLine());

        } catch (NumberFormatException d) {

            System.out.println("Coming back to the game...");

        }
    }


}


