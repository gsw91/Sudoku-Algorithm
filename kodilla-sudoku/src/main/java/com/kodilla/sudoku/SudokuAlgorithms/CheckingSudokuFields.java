package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class CheckingSudokuFields {
    private SudokuBoard sudokuBoard;

    public CheckingSudokuFields(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public List<Integer> checkPossibleValuesInField(SudokuBoard sudokuBoard, int row, int column) {
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValues = sudokuElement.getPossibleValues();


        return possibleValues;
    }

    //do usunięcia razem z poprawieniem klasy ValuesElimination
    public List<Integer> checkAllFields(SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues) {
        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
            for (int value = 1; value <= 9; value++) {
                for (int i = 1; i <= 9; i++) {
                    if (possibleValues.get(value) == sudokuBoard.getSudokuRow(row).get(i).getValue()) {
                        possibleValues.set(value, -1);
                    } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(column).getValue()) {
                        possibleValues.set(value, -1);
                    }
                    checkSections(sudokuBoard, possibleValues, value, row, column, i);
                }
            }
        }
        return possibleValues;
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
                    checkSections(sudokuBoard, possibleValues, value, row, column, i);
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

    public void checkColumn(SudokuBoard sudokuBoard, List<Integer> possibleValues, int row, int column) {
        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
            for (int currentRow = 1; currentRow < 10; currentRow++) {
                if (sudokuBoard.getSudokuRow(currentRow).get(column).getValue() > 0) {
                    int index = sudokuBoard.getSudokuRow(currentRow).get(column).getValue();
                    if (possibleValues.get(index) == sudokuBoard.getSudokuRow(currentRow).get(column).getValue()) {
                        possibleValues.set(index, -1);
                    }
                }
            }
        }
    }

    public void checkRow(SudokuBoard sudokuBoard, List<Integer> possibleValues, int row, int column) {
        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
            for (int currentColumn = 1; currentColumn < 10; currentColumn++) {
                if (sudokuBoard.getSudokuRow(row).get(currentColumn).getValue() > 0) {
                    int index = sudokuBoard.getSudokuRow(row).get(currentColumn).getValue();
                    if (possibleValues.get(index) == sudokuBoard.getSudokuRow(row).get(currentColumn).getValue()) {
                        possibleValues.set(index, -1);
                    }
                }
            }
        }
    }

    public void checkSections(SudokuBoard sudokuBoard, List<Integer> possibleValues, int value, int row, int column, int i) {
        CheckingSudokuFields checkingSudokuFields;

        if (row < 4 && column < 4 && i < 4) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionOne(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row < 4 && column >= 4 && column < 7 && i >= 4 && i < 7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionTwo(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row < 4 && column >= 7 && i >= 7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionThree(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 4 && row <= 6 && column < 4 && i < 4) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionFour(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 4 && row <= 6 && column >= 4 && column <= 6 && i >= 4 && i <= 6) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionFive(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 4 && row <= 6 && column >= 7 && i >= 7) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionSix(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 7 && column <= 3 && i <= 3) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionSeven(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 7 && column >= 4 && column <= 6 && i >= 4 && i <= 6) {
            checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            List<Integer> selectedValues = checkingSudokuFields.checkSectionEight(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val).intValue() != possibleValues.get(val).intValue()) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (row >= 7 && column >= 7 && i >= 7) {
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
            for (int row=1; row <= 3; row++){
                for (int column=1; column<=3; column++) {
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
            for (int row=1; row <= 3; row++){
                for (int column=4; column<=6; column++) {
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
            for (int row = 1; row <= 3; row++) {
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
            for (int row = 4; row <= 6; row++) {
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
            for (int row = 4; row <= 6; row++) {
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
            for (int row = 4; row <= 6; row++) {
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
            for (int row = 7; row <= 9; row++) {
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
            for (int row = 7; row <= 9; row++) {
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
            for (int row = 7; row <= 9; row++) {
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
