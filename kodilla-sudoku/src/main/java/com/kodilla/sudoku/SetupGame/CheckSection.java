package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;

import java.util.List;

public class CheckSection {
    private SudokuBoard sudokuBoard;
    //private List<Integer> possibleValues = sudokuElement.getPossibleValues();

    public CheckSection(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
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
