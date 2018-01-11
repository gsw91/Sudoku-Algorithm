package com.kodilla.rps.GameSystem;


import com.kodilla.rps.GameProcess;

import java.util.Scanner;


public class GameInformation {


    public void showWelcome() {

        System.out.println("Welcome in the game Rock - Paper - Scissors \n" +
                "\n Please insert your name.\n");

    }


    public void showRules() {

        System.out.println("\n Rules: \n" +
                "press 1 to throw Rock \n" +
                "press 2 to throw Paper \n" +
                "press 3 to throw Scissors \n" +
                "press x to end the game \n" +
                "press n to restart the game \n" +
                "\n Please insert quantity of winning rounds: ");

    }


    public int insertRoundsQuantity() throws NumberFormatException {

        Scanner scanner = new Scanner(System.in);
        String getLimit = scanner.nextLine();

        boolean isTrue = false;

        while(!isTrue){

            if((Integer.parseInt(getLimit))>0){
                isTrue = true;

            } else {

                throw new NumberFormatException();

            }

        }

        return Integer.parseInt(getLimit);

    }


    public void exitOrReset(String command) throws NumberFormatException {

        Scanner scanner = new Scanner(System.in);
        String confirm;

        if (command.equals("x")) {
            System.out.println("Do you really want to exit the game ? \n Insert y to exit, or any other key to return to the game.");
            confirm = scanner.nextLine();

            if (confirm.equals("y")) {
                System.out.println("Goodbye!");
                System.exit(0);

            } else {
                throw new NumberFormatException();
            }

        } else if (command.equals("n")) {
            System.out.println("Do you want to play one more time ? \n Insert y to begin, or any other key to return to the game.");
            confirm = scanner.nextLine();

            if (confirm.equals("y")) {
                System.out.println("Resetting the game... \n");
                GameProcess gameProcess = new GameProcess();
                gameProcess.play();

            } else {
                throw new NumberFormatException();
            }
        }

    }


    public void checkScore(int humanPlayerScore, int limitOfTheGame) {

        if (humanPlayerScore == limitOfTheGame) {
            System.out.println("\nYou win the game!!!\n");

        } else {
            System.out.println("\nYou lost with a computer...\n");
        }

    }


}



