package com.kodilla.sudoku.Board;

import com.kodilla.sudoku.Prototype.SudokuCloneable;

import java.util.ArrayList;

public class SudokuRow extends SudokuCloneable {

    private final static int MIN_INDEX = 0;
    private final static int MAX_INDEX = 9;
    private ArrayList<SudokuElement> elements;

    public SudokuRow() {
    }

    public ArrayList<SudokuElement> getElements() {
        return elements;
    }

    public ArrayList<SudokuElement> createRow() {
        elements = new ArrayList<>();
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            elements.add(i, new SudokuElement(SudokuElement.EMPTY));
        }
        return elements;
    }

    @Override
    public String toString() {
        String result = "";
        for (int n = MIN_INDEX+1; n <= MAX_INDEX; n++) {
            if (elements.get(n).getValue() == -1) {
                result += "|___";
            } else {
                result += "|_" + elements.get(n).getValue() + "_";
            }
        }
        result += "| \n";
        return result;
    }
}
