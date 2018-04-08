package com.kodilla.sudoku.Board;

import com.kodilla.sudoku.Prototype.SudokuCloneable;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow extends SudokuCloneable {

    private final static int MIN_INDEX = 0;
    private final static int MAX_INDEX = 9;
    private List<SudokuElement> elements;

    public SudokuRow() {
    }

    public SudokuRow(List<SudokuElement> elements) {
        this.elements = elements;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public void createRow() {
        elements = new ArrayList<>();
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            elements.add(i, new SudokuElement(SudokuElement.EMPTY));
        }
    }

    @Override
    public String toString() {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (int n = MIN_INDEX+1; n <= MAX_INDEX; n++) {
            if (elements.get(n).getValue() == -1) {
                stringBuilder.append("|___");
            } else {
                stringBuilder.append("|_").append(elements.get(n).getValue()).append("_");
            }
        }
        stringBuilder.append("| \n");
        result = stringBuilder.toString();
        return result;
    }
}
