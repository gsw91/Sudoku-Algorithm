package com.kodilla.sudoku.RandomForTests;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.SudokuAlgorithms.CheckingSudokuFields;

import java.util.List;

public class RandomBoardForTesting {

    public void createRandomBoard(SudokuBoard sudokuBoard, int quantityOfFigures) {
        insertRandomValueIntoBoard(sudokuBoard, quantityOfFigures);
        int allValues = countInsertedValues(sudokuBoard);
        System.out.println("Successfully inserted " + allValues + " values");
    }

    private void insertRandomValueIntoBoard(SudokuBoard sudokuBoard, int quantityOfFigures) throws IndexOutOfBoundsException {

        while (quantityOfFigures != 0) {
            SudokuElement sudokuElement = new SudokuElement();
            List<Integer> possibleValues = sudokuElement.getPossibleValues();
            CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
            RandomValueInsertionCondition randomValueInsertionCondition = new RandomValueInsertionCondition();

            int rowNumber = randomWithRange();
            int columnNumber = randomWithRange();
            int valueToInsertion = randomWithRange();

            randomValueInsertionCondition.checkInsertionPossibility(sudokuBoard, rowNumber, columnNumber, possibleValues);

            if (sudokuBoard.getSudokuRow(rowNumber).get(columnNumber).getValue() == -1) {
                if (possibleValues.indexOf(valueToInsertion)>=0) {
                    sudokuBoard.getSudokuRow(rowNumber).get(columnNumber).setValue(valueToInsertion);
                    quantityOfFigures--;
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