package com.kodilla.sudoku.ExamplesBoards;

import com.kodilla.sudoku.Board.SudokuBoard;

public class ExamplesBoards {

    public SudokuBoard getBoardLevelMedium() {
        //board medium no 1 from http://www.gim2.lubliniec.pl/sudoku/plansze.htm
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(3);
        sudokuBoard.getSudokuRow(1).get(5).setValue(4);
        sudokuBoard.getSudokuRow(1).get(7).setValue(2);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(2).get(2).setValue(5);
        sudokuBoard.getSudokuRow(2).get(6).setValue(3);
        sudokuBoard.getSudokuRow(2).get(7).setValue(7);
        sudokuBoard.getSudokuRow(2).get(8).setValue(4);
        sudokuBoard.getSudokuRow(3).get(3).setValue(4);
        sudokuBoard.getSudokuRow(3).get(5).setValue(5);
        sudokuBoard.getSudokuRow(3).get(6).setValue(1);
        sudokuBoard.getSudokuRow(3).get(8).setValue(8);
        sudokuBoard.getSudokuRow(4).get(2).setValue(3);
        sudokuBoard.getSudokuRow(4).get(5).setValue(6);
        sudokuBoard.getSudokuRow(4).get(7).setValue(9);
        sudokuBoard.getSudokuRow(4).get(9).setValue(7);
        sudokuBoard.getSudokuRow(5).get(2).setValue(4);
        sudokuBoard.getSudokuRow(5).get(4).setValue(8);
        sudokuBoard.getSudokuRow(5).get(6).setValue(7);
        sudokuBoard.getSudokuRow(6).get(2).setValue(6);
        sudokuBoard.getSudokuRow(6).get(6).setValue(5);
        sudokuBoard.getSudokuRow(6).get(7).setValue(4);
        sudokuBoard.getSudokuRow(6).get(8).setValue(2);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        sudokuBoard.getSudokuRow(7).get(5).setValue(2);
        sudokuBoard.getSudokuRow(7).get(6).setValue(8);
        sudokuBoard.getSudokuRow(7).get(7).setValue(6);
        sudokuBoard.getSudokuRow(8).get(2).setValue(9);
        sudokuBoard.getSudokuRow(8).get(4).setValue(3);
        sudokuBoard.getSudokuRow(8).get(8).setValue(5);
        sudokuBoard.getSudokuRow(8).get(9).setValue(2);
        sudokuBoard.getSudokuRow(9).get(1).setValue(4);
        sudokuBoard.getSudokuRow(9).get(2).setValue(2);
        sudokuBoard.getSudokuRow(9).get(5).setValue(1);
        sudokuBoard.getSudokuRow(9).get(8).setValue(7);

        return sudokuBoard;
    }

}
