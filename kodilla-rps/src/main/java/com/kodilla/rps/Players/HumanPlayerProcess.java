package com.kodilla.rps.Players;


import com.kodilla.rps.Figures.Figure;
import com.kodilla.rps.Figures.FiguresList;
import com.kodilla.rps.GameSystem.ConfirmationExitOrReset;
import com.kodilla.rps.GameSystem.GameInformation;
import com.kodilla.rps.Exceptions.RpsException;

import java.util.List;
import java.util.Scanner;


public final class HumanPlayerProcess {

    private String playerName;

    public HumanPlayerProcess(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String showFigure() throws RpsException {

        GameInformation gameInformation = new GameInformation();
        FiguresList figuresList = new FiguresList();
        List<Figure> figuresToDraw = figuresList.getFigures();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Put your number: 1 - Paper, 2 - Rock, 3 - Scissors");

        String command = scanner.nextLine();

        if (command.equals("1")||command.equals("2")||command.equals("3")) {

            int i = Integer.parseInt(command);

            System.out.println("You throws: " + figuresToDraw.get(i).getNameOfFigure());

            return figuresToDraw.get(Integer.parseInt(command)).getNameOfFigure();

        } else if (command.equals("n")) {

            System.out.println("Do you really want to reset this game ? \n Insert y to exit, or any other key to return to the game.");

            try {

                ConfirmationExitOrReset confirmationExitOrReset = new ConfirmationExitOrReset();
                confirmationExitOrReset.confirmReset(scanner.nextLine());


            } catch (NumberFormatException e) {

                System.out.println("Coming back to the game...");
                throw new RpsException();
            }

        } else if (command.equals("x")) {

        System.out.println("Do you really want to exit the game ? \n Insert y to exit, or any other key to return to the game.");

        try {

            ConfirmationExitOrReset confirmationExitOrReset = new ConfirmationExitOrReset();
            confirmationExitOrReset.confirmExit(scanner.nextLine());


        } catch (NumberFormatException e) {

            System.out.println("Coming back to the game...");
            throw new RpsException();
        }

        } else {
            throw new RpsException();
        }

        return figuresToDraw.get(Integer.parseInt(command)).getNameOfFigure();
    }


}
