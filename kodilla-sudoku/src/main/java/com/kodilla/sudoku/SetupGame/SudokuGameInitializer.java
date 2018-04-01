package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuGameInitializer {

    private Scanner scanner = new Scanner(System.in);

    public void StartGame() {

        // Tworzenie tablicy
        GameConfiguration gameConfiguration = new GameConfiguration();

        // Powitanie i wprowadzenie cyfr
        gameConfiguration.sudokuWelcome();
        SudokuBoard sudokuBoard = gameConfiguration.fortifyBoardWithFigures();

        // Zapętlone działanie aplikacji dopóki sudoku nie zostanie rozwiązane
        boolean gameFinished = false;
        while (!gameFinished) {

            //Sprawdzanie możliwych liczb do wprowadzenia i wprowadzenie, ewentualnie błąd
            boolean firstAlgorithm = false;
            while (!firstAlgorithm) {
                int insertedValues = gameConfiguration.insertValues(sudokuBoard);
                if (insertedValues == 0) {
                    firstAlgorithm = true;
                }
            }

            //Warunek zakończenia gry
            List<Integer> endingGame = new ArrayList<>();
            for(int row = 1; row < 10; row ++) {
                for(int column = 1; column < 10; column ++) {
                    if (sudokuBoard.getSudokuRow(row).get(column).getValue() < 0) {
                        endingGame.add(sudokuBoard.getSudokuRow(row).get(column).getValue());
                    }
                }
            }
            if (endingGame.size() == 0) {
                System.out.println("Board is filled. The end.\n" +
                        "Press any key to quit or write R to restart app.");
                String decision = scanner.nextLine();

                if (decision.equals("R")) {
                    StartGame();
                } else {
                    break;
                }
            }

            //Wprowadzanie ręcznie liczbt
            try {
                System.out.println("Please insert new value by hand, algorithm sees no possibilities!\n");
                gameConfiguration.insertOneElement(sudokuBoard);
            } catch (NumberFormatException e) {
                System.out.println("Insert correct values \n");
            }

        }
    }

}
