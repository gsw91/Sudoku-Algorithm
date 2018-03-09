package com.kodilla.sudoku.CheckingAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;

import java.util.List;

public class CheckingSections {
    private SudokuBoard sudokuBoard;
    private CheckingSections checkingSections;
    //private List<Integer> possibleValues = sudokuElement.getPossibleValues();

    public CheckingSections(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public List<Integer> checkAllSections(SudokuBoard sudokuBoard, List<Integer> possibleValues, int value, int i, int k, int n) {

        if (i<4 && k<4 && n<4) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionOne(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i<4 && k>=4 && k<7 && n>=4 && n<7) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionTwo(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i<4 && k>=7 && n>=7) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionThree(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k<4 && n<4) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionFour(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k>=4 && k<=6 && n>=4 && n<=6) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionFive(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=4 && i<=6 && k>=7 && n>=7) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionSix(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k<=3 && n<=3) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionSeven(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k>=4 && k<=6 && n>=4 && n<=6) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionEight(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }

        if (i>=7 && k>=7 && n>=7) {
            checkingSections = new CheckingSections(sudokuBoard);
            List<Integer> selectedValues = checkingSections.checkSectionNine(possibleValues);
            for (int val = 0; val < 10; val++) {
                if (selectedValues.get(val) != possibleValues.get(val)) {
                    possibleValues.set(value, -1);
                }
            }
        }
        return possibleValues;
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

    public List<Integer> checkSectionTwo(List<Integer> possibleValues){
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

    public List<Integer> checkSectionThree(List<Integer> possibleValues) {
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

    public List<Integer> checkSectionFour(List<Integer> possibleValues){
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

    public List<Integer> checkSectionFive(List<Integer> possibleValues){
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

    public List<Integer> checkSectionSix(List<Integer> possibleValues){
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

    public List<Integer> checkSectionSeven(List<Integer> possibleValues){
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

    public List<Integer> checkSectionEight(List<Integer> possibleValues){
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

    public List<Integer> checkSectionNine(List<Integer> possibleValues){
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
