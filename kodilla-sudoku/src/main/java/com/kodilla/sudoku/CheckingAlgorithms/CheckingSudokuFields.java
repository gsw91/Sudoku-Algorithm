package com.kodilla.sudoku.CheckingAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.SetupGame.ValuesInsertionCondition;

import java.util.ArrayList;
import java.util.List;

public class CheckingSudokuFields {
    private SudokuBoard sudokuBoard;

    public CheckingSudokuFields(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public int checkAllFields(SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues, int countInsertedValues) {
        ValuesInsertionCondition valuesInsertionCondition;
        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
            for (int value = 1; value <= 9; value++) {
                for (int i = 1; i <= 9; i++) {
                    if (possibleValues.get(value) == sudokuBoard.getSudokuRow(row).get(i).getValue()) {
                        possibleValues.set(value, -1);
                    } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(column).getValue()) {
                        possibleValues.set(value, -1);
                    }
                    checkAllSections(sudokuBoard, possibleValues, value, row, column, i);
                }
            }
            List<Integer> checkedPossibleValues = new ArrayList<>();
            for (int d = 0; d <= 9; d++) {
                if (possibleValues.get(d) > 0) {
                    checkedPossibleValues.add(possibleValues.get(d));
                }
            }

            //System.out.println("Possible values " + checkedPossibleValues.size() + " for row: " + row + ", column: " + column + ", " + checkedPossibleValues);
            valuesInsertionCondition = new ValuesInsertionCondition(checkedPossibleValues, sudokuBoard, row, column);
            if (valuesInsertionCondition.countInsertionValues() > 0) {
                countInsertedValues++;
            }
        } else if (sudokuBoard.getSudokuRow(row).get(column).getValue() != -1) {
            //System.out.println("Row: " + row + ", column: " + column + ", inserted: " + sudokuBoard.getSudokuRow(row).get(column).getValue());
        }
        return countInsertedValues;
    }

    public void checkAllSections(SudokuBoard sudokuBoard, List<Integer> possibleValues, int value, int i, int k, int n) {
        CheckingSudokuFields checkingSudokuFields;

        if (i<4 && k<4 && n<4) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionOne(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i<4 && k>=4 && k<7 && n>=4 && n<7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionTwo(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i<4 && k>=7 && n>=7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionThree(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k<4 && n<4) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionFour(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k>=4 && k<=6 && n>=4 && n<=6) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionFive(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k>=7 && n>=7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionSix(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k<=3 && n<=3) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionSeven(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k>=4 && k<=6 && n>=4 && n<=6) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionEight(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k>=7 && n>=7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionNine(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }
    }

    public List<Integer> checkSectionOne(List<Integer> possibleValues) {
        for (int i=0; i<10; i++) {
            for (int row=1; row<4; row++){
                for (int column=1; column<4; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionTwo(List<Integer> possibleValues){
        for (int i=0; i<10; i++) {
            for (int row=1; row<4; row++){
                for (int column=4; column<7; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionThree(List<Integer> possibleValues) {
        for (int i = 0; i < 10; i++) {
            for (int row = 1; row < 4; row++) {
                for (int column = 7; column <= 9; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionFour(List<Integer> possibleValues){
        for (int i = 0; i < 10; i++) {
            for (int row = 4; row < 7; row++) {
                for (int column = 1; column <= 3; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionFive(List<Integer> possibleValues){
        for (int i = 0; i <= 9; i++) {
            for (int row = 4; row < 7; row++) {
                for (int column = 4; column <= 6; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionSix(List<Integer> possibleValues){
        for (int i = 0; i < 10; i++) {
            for (int row = 4; row < 7; row++) {
                for (int column = 7; column <= 9; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionSeven(List<Integer> possibleValues){
        for (int i = 0; i < 10; i++) {
            for (int row = 7; row < 10; row++) {
                for (int column = 1; column <= 3; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionEight(List<Integer> possibleValues){
        for (int i = 0; i < 10; i++) {
            for (int row = 7; row < 9; row++) {
                for (int column = 4; column <= 6; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

    private List<Integer> checkSectionNine(List<Integer> possibleValues){
        for (int i = 0; i < 10; i++) {
            for (int row = 7; row < 9; row++) {
                for (int column = 7; column <= 9; column++) {
                    if (possibleValues.get(i) == sudokuBoard.getSudokuRow(row).get(column).getValue()) {
                        possibleValues.set(i, -1);
                    }
                }
            }
        }
        return possibleValues;
    }

}
