package com.kodilla.sudoku.Board;


public class SudokuElement {

    public static int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
