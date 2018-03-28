package com.kodilla.sudoku.RandomForTests;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.SudokuAlgorithms.CheckingSudokuFields;

import java.util.ArrayList;
import java.util.List;

public class RandomValueInsertionCondition {

   public List<Integer> checkInsertionPossibility (SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues){
       CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
       List<Integer> checkedPossibleValues = new ArrayList<>();
       if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
           for (int value = 1; value <= 9; value++) {
               for (int i = 1; i <= 9; i++) {
                   if (possibleValues.get(value) == sudokuBoard.getSudokuRow(row).get(i).getValue()) {
                       possibleValues.set(value, -1);
                   } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(column).getValue()) {
                       possibleValues.set(value, -1);
                   }
                   checkingSudokuFields.checkSections(sudokuBoard, possibleValues, value, row, column, i);
               }
           }
       }
       return possibleValues;
   }


   public void showPossibleValues (List<Integer> possibleValues, List<Integer> checkedPossibleValues, int row, int column) {
       for (int d = 0; d <= 9; d++) {
           if (possibleValues.get(d) > 0) {
               checkedPossibleValues.add(possibleValues.get(d));
           }
       }
       System.out.println("Possible values " + checkedPossibleValues.size() + " for row: " + row + ", column: " + column + ", " + checkedPossibleValues);
   }

}
