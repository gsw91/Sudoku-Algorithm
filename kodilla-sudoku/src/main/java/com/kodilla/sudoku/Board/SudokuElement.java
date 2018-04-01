package com.kodilla.sudoku.Board;


import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement() {
    }

    public SudokuElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        possibleValues.add(0, -1);
        for (int i = 1; i <=9; i++) {
            possibleValues.add(i, i);
        }

        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
