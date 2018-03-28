package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class ValuesInsertionCondition {

    private List<Integer> possibleValues;
    private SudokuBoard sudokuBoard;
    private int row;
    private int column;

    public ValuesInsertionCondition (List<Integer> possibleValues, SudokuBoard sudokuBoard, int row, int column) {
        this.possibleValues = possibleValues;
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.column = column;
    }

    public int countInsertionValues() {
        int insertionsNumber = 0;
        if (possibleValues.size()==1) {
            sudokuBoard.getSudokuRow(row).get(column).setValue(possibleValues.get(0));
            System.out.println("    Value " + possibleValues.get(0) + " inserted into row: " + row + ", column: " + column);
            insertionsNumber++;
        }
        return insertionsNumber;
    }


}
