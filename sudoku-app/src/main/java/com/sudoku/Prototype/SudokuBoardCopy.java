package com.sudoku.Prototype;


import com.sudoku.Board.SudokuBoard;

public class SudokuBoardCopy {

    private SudokuBoard sudokuBoard;
    private int row;
    private int column;
    private int value;

    public SudokuBoardCopy(SudokuBoard sudokuBoard, int row, int column, int value) {
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }
}
