package com.kodilla.sudoku;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.SetupGame.GameConfiguration;

public class SudokuGame {

    public static void main (String[]Args) {

        // pętla w której powinna działać gra
        // boolean gameFinished = false;
        // while(!gameFinished) {
        //    SudokuGame theGame = new SudokuGame();
        //    gameFinished = theGame.resolveSudoku();
        //  }

        // Wprowadzanie liczb do tablicy

        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        gameConfiguration.fortifyBoardWithFigures(sudokuBoard);

    }
}
