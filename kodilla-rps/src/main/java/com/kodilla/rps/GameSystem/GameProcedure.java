package com.kodilla.rps.GameSystem;


import com.kodilla.rps.Exceptions.RpsException;
import com.kodilla.rps.Players.ComputerPlayerProcess;
import com.kodilla.rps.Players.HumanPlayerProcess;


public class GameProcedure {


    public void runProcedure(HumanPlayerProcess humanPlayerProcess, ComputerPlayerProcess computerPlayerProcess, int humanPlayerScore, int computerScore) {

        try {

            String player1 = humanPlayerProcess.showFigure();
            String player2 = computerPlayerProcess.showFigure();

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

