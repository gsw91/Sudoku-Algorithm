package com.kodilla.sudoku.Board;

import com.kodilla.sudoku.Prototype.SudokuCloneable;

import java.util.ArrayList;
import java.util.List;

public final class SudokuBoard extends SudokuCloneable {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private List<SudokuRow> sudokuRows;

    public SudokuBoard() {
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public List<SudokuElement> getSudokuRow(int row) {
        return sudokuRows.get(row).getElements();
    }

    public void createNewBoard() {
        sudokuRows = new ArrayList<>();
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            sudokuRow.createRow();
            sudokuRows.add(i, sudokuRow);
        }
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.sudokuRows = new ArrayList<>();
        for (SudokuRow row : sudokuRows) {
           List<SudokuElement> clonedElements = new ArrayList<>();
           SudokuRow clonedRow = new SudokuRow(clonedElements);
            for (SudokuElement element : row.getElements()) {
                int value = element.getValue();
                SudokuElement clonedElement = new SudokuElement(value);
                clonedRow.getElements().add(clonedElement);
            }
            clonedBoard.sudokuRows.add(clonedRow);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {

        String top = " ___ ___ ___ ___ ___ ___ ___ ___ ___\n";
        String result = "";
        for (int n = MIN_INDEX+1; n <= MAX_INDEX; n++) {
            result += getSudokuRows().get(n);
        }
            return top + result;
    }
}
