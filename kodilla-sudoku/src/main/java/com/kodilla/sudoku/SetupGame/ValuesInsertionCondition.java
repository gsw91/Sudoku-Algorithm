package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class ValuesInsertionCondition {

    private List<Integer> possibleValues;
    private SudokuBoard sudokuBoard;
    private int row;
    private int column;

    public ValuesInsertionCondition(List<Integer> possibleValues, SudokuBoard sudokuBoard, int row, int column) {
        this.possibleValues = possibleValues;
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.column = column;
    }

    public void tryInsertValue() {
        if (possibleValues.size()==1){
            sudokuBoard.getSudokuRow(row).get(column).setValue(possibleValues.get(0));
            System.out.println("Value " + possibleValues.get(0) + " inserted into row: " + row + ", column: " + column);
        } else {
            //System.out.println("Impossible!");
        }
    }


}
