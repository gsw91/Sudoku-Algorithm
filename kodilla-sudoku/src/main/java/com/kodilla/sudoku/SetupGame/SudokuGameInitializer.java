package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.Board.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public class SudokuGameInitializer {

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


            try {
                System.out.println("Please insert new value by hand, algorithm sees no possibilities!\n");
                gameConfiguration.insertOneElement(sudokuBoard);
            } catch (NumberFormatException e) {
                System.out.println("Insert correct values \n");
            }

            List<Integer> endingGame = new ArrayList<>();
            for(SudokuRow row: sudokuBoard.getSudokuRows()) {
                for(SudokuElement element: row.getElements()) {
                    if (element.getValue() > 0) {
                        endingGame.add(element.getValue());

                    }
                }
            }
            if (endingGame.size() == 0) {
                System.exit(0);
            }
        }

    }


}
