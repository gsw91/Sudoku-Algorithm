package com.kodilla.rps.Players;


import com.kodilla.rps.Figures.Figure;
import com.kodilla.rps.Figures.FiguresList;
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

        System.out.println("\n Put your number: 1 - Paper, 2 - Rock, 3 - Scissors");

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        if(command.equals("x")||command.equals("n")) {

            try {

                gameInformation.exitOrReset(command);

            } catch (NumberFormatException e){

                System.out.println("Coming back to the game...");
                showFigure();

            }

        } else if (command.equals("1")||command.equals("2")||command.equals("3")) {

            int i = Integer.parseInt(command);

            System.out.println("You throws: " + figuresToDraw.get(i).getNameOfFigure());

            return figuresToDraw.get(i).getNameOfFigure();

        } else {

            throw new RpsException();

        }

        return figuresToDraw.get(Integer.parseInt(command)).getNameOfFigure();

    }


}
