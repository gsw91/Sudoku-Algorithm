package com.kodilla.rps.Figures;


import com.kodilla.rps.Exceptions.RpsException;
import com.kodilla.rps.GameSystem.EndOfGame;
import com.kodilla.rps.GameSystem.GameInformation;
import com.kodilla.rps.Players.ComputerPlayerProcess;
import com.kodilla.rps.Players.HumanPlayerProcess;


public class Figure {

    private String nameOfFigure;

    public Figure(String nameOfFigure) {
        this.nameOfFigure = nameOfFigure;
    }

    public String getNameOfFigure() {
        return nameOfFigure;
    }

    public void compareScore(HumanPlayerProcess humanPlayerProcess, ComputerPlayerProcess computerPlayerProcess, int gameLimit, int startHumanPlayerScore, int starcComputerScore) {

        boolean doWeFinished = false;
        while (!doWeFinished) {

            GameInformation gameInformation = new GameInformation();

            if (startHumanPlayerScore == gameLimit || starcComputerScore == gameLimit) {

                gameInformation.checkScore(startHumanPlayerScore, gameLimit);
                EndOfGame endOfGame = new EndOfGame();
                endOfGame.endingGame();

            } else {

                try {

                    String player1 = humanPlayerProcess.showFigure();
                    String player2 = computerPlayerProcess.showFigure();

                    if (player1.equals(player2)) {

                        System.out.println("Tie!!! One more time! \n");

                    } else {

                        if (player1.equals("Rock")) {

                            if (player2.equals("Paper")) {
                                System.out.println("You lost! \n");
                                starcComputerScore++;

                            } else {
                                System.out.print("You win! \n");
                                startHumanPlayerScore++;
                            }
                        }

                        if (player1.equals("Scissors")) {

                            if (player2.equals("Rock")) {
                                System.out.println("You lost! \n");
                                starcComputerScore++;

                            } else {
                                System.out.print("You win! \n");
                                startHumanPlayerScore++;
                            }
                        }

                        if (player1.equals("Paper")) {

                            if (player2.equals("Scissors")) {
                                System.out.println("You lost! \n");
                                starcComputerScore++;

                            } else {
                                System.out.print("You win! \n");
                                startHumanPlayerScore++;
                            }
                        }

                    }

                    System.out.println("Your score: " + startHumanPlayerScore + " vs. computer score: " + starcComputerScore + "\n");

                } catch (RpsException e) {
                    System.out.println("Insert correct key");
                }

            }

        }

    }


}