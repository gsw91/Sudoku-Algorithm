package com.kodilla.sudoku.Board;

import java.util.ArrayList;

public class SudokuBoard {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private ArrayList<SudokuRow> sudokuRows;
    private SudokuRow sudokuRow;

    public SudokuBoard() {
    }

    public ArrayList<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public ArrayList<SudokuElement> getSudokuRow(int row) {
        return sudokuRows.get(row).getElements();
    }

    public void createNewBoard() {
        sudokuRows = new ArrayList<>();
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            sudokuRow = new SudokuRow();
            sudokuRow.createRow();
            sudokuRows.add(i, sudokuRow);
        }
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
