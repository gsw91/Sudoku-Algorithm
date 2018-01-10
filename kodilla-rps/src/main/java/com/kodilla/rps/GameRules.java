package com.kodilla.rps;


import com.kodilla.rps.GameSystem.GameInformation;
import com.kodilla.rps.GameSystem.RoundsLimit;
import com.kodilla.rps.Players.ComputerPlayer;
import com.kodilla.rps.Players.HumanPlayer;
import com.kodilla.rps.Players.HumanPlayerName;


public class GameRules {


    public void play() {

        GameInformation gameInformation = new GameInformation();
        gameInformation.showWelcome();

        HumanPlayerName humanPlayerName = new HumanPlayerName();
        String playerName = humanPlayerName.insertHumanName();

        HumanPlayer humanPlayer = new HumanPlayer(playerName);
        System.out.print("Hello " + humanPlayer.getPlayerName());

        gameInformation.showRules();

        RoundsLimit roundLimit = new RoundsLimit();
        int limitOfTheGame = roundLimit.getLimit();

        boolean end = false;
        int humanPlayerScore = 0;
        int computerScore = 0;

        while (!end) {

            if (humanPlayerScore == limitOfTheGame || computerScore == limitOfTheGame) {

                boolean endOfGame = false;

                while(!endOfGame) {

                    try {
                        gameInformation.endingGame();
                        endOfGame = true;

                    } catch (RpsException exception) {

                        System.out.println("Coming back to the game...");

                    }
                }

                if (humanPlayerScore == limitOfTheGame) {
                    System.out.println("\nYou win the game!!!\n");
                } else {
                    System.out.println("\nYou lost with a computer...\n");
                }

            } else {

                try {

                    String player1 = humanPlayer.showFigure();
                    ComputerPlayer computerPlayer = new ComputerPlayer();
                    String player2 = computerPlayer.showFigure();

                    if (player1.equals(player2)) {

                        System.out.println("Tie!!! One more time! \n");

                    } else {

                        if (player1.equals("Rock")) {
                            if (player2.equals("Paper")) {
                                System.out.println("You lost! \n");
                                computerScore++;
                            } else {
                                System.out.print("You win! \n");
                                humanPlayerScore++;
                            }
                        }

                        if (player1.equals("Scissors")) {
                            if (player2.equals("Rock")) {
                                System.out.println("You lost! \n");
                                computerScore++;
                            } else {
                                System.out.print("You win! \n");
                                humanPlayerScore++;
                            }
                        }

                        if (player1.equals("Paper")) {
                            if (player2.equals("Scissors")) {
                                System.out.println("You lost! \n");
                                computerScore++;
                            } else {
                                System.out.print("You win! \n");
                                humanPlayerScore++;
                            }
                        }
                    }

                    System.out.println("Your score: " + humanPlayerScore + " vs. computer score: " + computerScore + "\n");

                } catch (RpsException e) {
                    System.out.println("Insert correct key");

                }

            }

        }

    }


}