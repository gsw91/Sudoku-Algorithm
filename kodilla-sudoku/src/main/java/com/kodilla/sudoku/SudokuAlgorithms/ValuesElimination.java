package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class ValuesElimination {

    private List<List<Integer>> otherLists = new ArrayList<>();
    private List<Integer> checkedList = new ArrayList<>();
    private CheckingSudokuFields checkingSudokuFields;

    public int insertValueByElimination(SudokuBoard sudokuBoard, int row, int column) {

        int score;
        checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibleValues = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, row, column);
        score = insertValueInColumnByElimination(sudokuBoard, possibleValues, row, column);

        if (score == 0) {
            score = insertValueInRowByElimination(sudokuBoard, possibleValues, row, column);
        }
        return score;
    }

    private int insertValueInColumnByElimination(SudokuBoard sudokuBoard, List<Integer> possibleValues, int row, int column) throws IndexOutOfBoundsException {

        int score = 0;
        otherLists = new ArrayList<>();

        for (int rowNumber = 1; rowNumber <= 9; rowNumber++) {
            if (sudokuBoard.getSudokuRow(rowNumber).get(column).getValue() == -1) {
                if (rowNumber != row) {
                    checkedList = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, rowNumber, column);
                    otherLists.add(checkedList);
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            int countThisShit = 0;
            if (possibleValues.get(i) > 0) {
                for (List<Integer> list : otherLists) {
                    if (list.get(i) != i && possibleValues.get(i) == i) {
                        countThisShit++;
                    }
              //      System.out.println("Value nr " + i + " from list " + possibleValues + " " + possibleValues.get(i) +
              //              ", from list " + list + " " + list.get(i) + ", counted " + countThisShit );
                }
                if (countThisShit == otherLists.size()) {
                    sudokuBoard.getSudokuRow(row).get(column).setValue(possibleValues.get(i));
                    score = 1;
                }
            }
        }

        //    List<Integer> finalList = checkingSudokuFields.addPossibilitiesToNewList(possibleValues);
        //    if (finalList.size() == 1) {
        //        sudokuBoard.getSudokuRow(row).get(column).setValue(finalList.get(0));
        //        score = 1;
        //        System.out.println("Elimination process in column - Value: " + finalList.get(0) + " inserted into row: " + row + " column: " + column);
        //    }
        return score;
    }

    private int insertValueInRowByElimination(SudokuBoard sudokuBoard, List<Integer> possibleValues, int row, int column) throws IndexOutOfBoundsException {

        int score = 0;
        otherLists = new ArrayList<>();

        for (int columnNumber = 1; columnNumber < 10; columnNumber++) {
            if (sudokuBoard.getSudokuRow(row).get(columnNumber).getValue() == -1) {
                if (columnNumber != column) {
                    checkedList = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, row, columnNumber);
                    otherLists.add(checkedList);
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            int countThisShit = 0;
            if (possibleValues.get(i) > 0) {
                for (List<Integer> list : otherLists) {
                    if (list.get(i) != i && possibleValues.get(i) == i) {
                        countThisShit = countThisShit + 1;
                    }
                    //System.out.println("Value nr " + i + " from list " + possibleValues + " " + possibleValues.get(i) +
                    //        ", from list " + list + " " + list.get(i) + ", counted " + countThisShit );
                }
                if (countThisShit == otherLists.size()) {
                    sudokuBoard.getSudokuRow(row).get(column).setValue(possibleValues.get(i)); //possibleValues.set(i, -1);
                    score = 1;
                }
            }
        }

        // List<Integer> finalList = checkingSudokuFields.addPossibilitiesToNewList(possibleValues);
        // if (finalList.size() == 1) {
        //    sudokuBoard.getSudokuRow(row).get(column).setValue(finalList.get(0));
        //    score++;
        //   System.out.println("Elimination process in row - Value: " + finalList.get(0) + " inserted into row: " + row + " column: " + column);
        // }
        return score;
    }
}