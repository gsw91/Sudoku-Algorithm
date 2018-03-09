package com.kodilla.sudoku;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.Board.SudokuRow;
import com.kodilla.sudoku.SetupGame.GameConfiguration;
import com.kodilla.sudoku.SetupGame.SudokuElementException;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {

    public static void main(String[] Args) {
        // Wprowadzanie liczb do tablicy
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();

        gameConfiguration.fortifyBoardWithFigures(sudokuBoard);

        boolean gameFinished = false;
        while (!gameFinished) {

            for (int i = 0; i < 5; i++) {

                gameConfiguration.checkPossibleFigures(sudokuBoard);

            }
            try {
                gameConfiguration.insertElement(sudokuBoard);
            } catch (SudokuElementException e) {
                System.out.println("Insert correct values");
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
