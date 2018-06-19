package com.sudoku.Board;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement() {
        possibleValues.add(0, EMPTY);
        for (int i = 1; i <=9; i++) {
            possibleValues.add(i, i);
        }
    }

    public SudokuElement(int value) {
        this.value = value;
        possibleValues.add(0, EMPTY);
        for (int i = 1; i <=9; i++) {
            possibleValues.add(i, i);
        }
    }

    public int getValue() {
        return value;
    }



    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

}