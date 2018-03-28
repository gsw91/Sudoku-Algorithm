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
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();

        // Wprowadzenie cyfr
        gameConfiguration.fortifyBoardWithFigures(sudokuBoard);

        // Zapętlone działanie aplikacji
        boolean gameFinished = false;
        while (!gameFinished) {

            //Sprawdzanie możliwych liczb do wprowadzenia i ewentualne wprowadzenie
            gameConfiguration.checkPossibleFiguresAndInsert(sudokuBoard);
            //Wprowadzenie jedynej możliwej liczby do pola

            //W razie problemu błąd




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
                }
                break;
            }

            //Wprowadzanie liczb ręcznie
            try {
                System.out.println("Please insert new value by hand, algorithm sees no possibilities!\n");
                gameConfiguration.insertOneElement(sudokuBoard);
            } catch (NumberFormatException e) {
                System.out.println("Insert correct values \n");
            }
        }
    }

}
