package com.kodilla.rps.Players;


import com.kodilla.rps.Figures.Figure;
import com.kodilla.rps.Figures.FiguresList;
import com.kodilla.rps.GameRules;
import com.kodilla.rps.GameSystem.GameInformation;
import com.kodilla.rps.RpsException;

import java.util.List;
import java.util.Scanner;


public final class HumanPlayer {

    private String playerName;

    public HumanPlayer(String playerName) {
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

        if(command.equals("x")) {
            System.out.println("Do you really want to exit ? \nInsert y to exit, or any other key to return to the game. \n");
            String confirm = scanner.nextLine();
            if(confirm.equals("y")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                throw new RpsException();
            }

        } else if (command.equals("n")) {
            System.out.println("Do you want to finish current game ? \n Insert y to restart, or any other key to return to the game.");
            String confirm = scanner.nextLine();
            if(confirm.equals("y")) {
                System.out.println("Resetting the game... \n");
                GameRules gameRules = new GameRules();
                gameRules.play();
            } else {
                throw new RpsException();
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
