package com.kodilla.sudoku.RandomForTests;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.SudokuAlgorithms.CheckingSudokuFields;

import java.util.List;

public class RandomBoard {

    public void createRandomBoard(SudokuBoard sudokuBoard, int quantityOfFigures) {
        insertRandomValueIntoBoard(sudokuBoard, quantityOfFigures);
        int allValues = countInsertedValues(sudokuBoard);
        System.out.println("Successfully inserted " + allValues + " values");
    }

    private void insertRandomValueIntoBoard(SudokuBoard sudokuBoard, int quantityOfFigures) throws IndexOutOfBoundsException {

        while (quantityOfFigures != 0) {
            SudokuElement sudokuElement = new SudokuElement();
            List<Integer> possibleValues = sudokuElement.getPossibleValues();

            int rowNumber = randomWithRange();
            int columnNumber = randomWithRange();
            int valueToInsertion = randomWithRange();

            checkInsertionPossibility(sudokuBoard, rowNumber, columnNumber, possibleValues);

            if (sudokuBoard.getSudokuRow(rowNumber).get(columnNumber).getValue() == -1) {
                if (possibleValues.indexOf(valueToInsertion)>=0) {
                    sudokuBoard.getSudokuRow(rowNumber).get(columnNumber).setValue(valueToInsertion);
                    quantityOfFigures--;
                }
            }
        }
    }

    private void checkInsertionPossibility (SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues){
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
            for (int value = 1; value <= 9; value++) {
                for (int i = 1; i <= 9; i++) {
                    if (possibleValues.get(value) == sudokuBoard.getSudokuRow(row).get(i).getValue()) {
                        possibleValues.set(value, -1);
                    } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(column).getValue()) {
                        possibleValues.set(value, -1);
                    }
                    checkingSudokuFields.checkSections(sudokuBoard, possibleValues, row, column);
                }
            }
        }
    }

    public int countInsertedValues(SudokuBoard sudokuBoard) {
        int allValues = 0;

        for(int row = 1; row<10; row++){
            for(int column=1; column<10; column++) {
                if(sudokuBoard.getSudokuRow(row).get(column).getValue()>0){
                    allValues++;
                }
            }
        }
        return allValues;
    }


    private int randomWithRange()
    {
        int min =1;
        int max =9;
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

}