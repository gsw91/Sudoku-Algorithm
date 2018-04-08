package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.ExamplesBoards.ExamplesBoards;
import com.kodilla.sudoku.SetupGame.GameConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckingSudokuFieldsTest {

    @Test
    public void testEliminationAlgorithm() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelMediumOne();
        CheckingSudokuFields checkField = new CheckingSudokuFields(sudokuBoard);
        //when
        ValuesElimination valuesElimination = new ValuesElimination();

        List<Integer> possibleValuesR4C6 = checkField.checkPossibleValuesInField(sudokuBoard, 4, 6);
        System.out.println("Row 4 column 6 possible values before elimination: " + possibleValuesR4C6);
        valuesElimination.insertValueByElimination(sudokuBoard,4, 1);
        System.out.println("Row 4 column 1 possible values after elimination: " + possibleValuesR4C6);

        List<Integer> possibleValuesR6C3 = checkField.checkPossibleValuesInField(sudokuBoard, 6, 3);
        System.out.println("Row 6 column 3 possible values before elimination: " + possibleValuesR6C3);
        valuesElimination.insertValueByElimination(sudokuBoard, 6, 3);
        System.out.println("Row 6 column 3 possible values after elimination: " + possibleValuesR6C3);

        List<Integer> possibleValuesR5C5 = checkField.checkPossibleValuesInField(sudokuBoard,5, 5);
        System.out.println("Row 5 column 5 possible values before elimination: " + possibleValuesR5C5);
        valuesElimination.insertValueByElimination(sudokuBoard, 5, 5);
        System.out.println("Row 5 column 5 possible values after elimination: " + possibleValuesR5C5);

        List<Integer> possibleValuesR7C8 = checkField.checkPossibleValuesInField(sudokuBoard,7, 8);
        System.out.println("Row 7 column 8 possible values before elimination: " + possibleValuesR7C8);
        valuesElimination.insertValueByElimination(sudokuBoard, 7, 8);
        System.out.println("Row 7 column 8 possible values after elimination: " + possibleValuesR7C8);

        //then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testInsertValueIntoColumnByElimination() {
        //given
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(1).setValue(3);
        sudokuBoard.getSudokuRow(4).get(1).setValue(4);
        sudokuBoard.getSudokuRow(5).get(1).setValue(5);
        sudokuBoard.getSudokuRow(6).get(1).setValue(6);
        sudokuBoard.getSudokuRow(8).get(4).setValue(9);
        sudokuBoard.getSudokuRow(9).get(7).setValue(9);
        //when
        ValuesElimination elimination = new ValuesElimination();
        elimination.insertValueByElimination(sudokuBoard, 7, 1);
        //then
        Assert.assertEquals(9, sudokuBoard.getSudokuRow(7).get(1).getValue());
        System.out.println(sudokuBoard);
    }

    @Test
    public void testInsertValueIntoRowByElimination() {
        //given
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(1).get(3).setValue(3);
        sudokuBoard.getSudokuRow(1).get(4).setValue(4);
        sudokuBoard.getSudokuRow(1).get(5).setValue(5);
        sudokuBoard.getSudokuRow(1).get(6).setValue(6);
        sudokuBoard.getSudokuRow(4).get(8).setValue(7);
        sudokuBoard.getSudokuRow(7).get(9).setValue(7);
        //when
        ValuesElimination elimination = new ValuesElimination();
        elimination.insertValueByElimination(sudokuBoard, 1, 7);
        //then
        Assert.assertEquals(7, sudokuBoard.getSudokuRow(1).get(7).getValue());
        System.out.println(sudokuBoard);
    }


    @Test
    public void checkSudokuElement() {
        //given
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(1).setValue(4);
        sudokuBoard.getSudokuRow(4).get(1).setValue(5);
        sudokuBoard.getSudokuRow(5).get(1).setValue(6);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        sudokuBoard.getSudokuRow(1).get(2).setValue(9);
        sudokuBoard.getSudokuRow(1).get(3).setValue(3);
        sudokuBoard.getSudokuRow(1).get(4).setValue(8);
        sudokuBoard.getSudokuRow(1).get(5).setValue(7);
        sudokuBoard.getSudokuRow(1).get(6).setValue(6);
        sudokuBoard.getSudokuRow(1).get(7).setValue(5);
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibleValues;
        //when
        possibleValues = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, 3, 3 );
        List<Integer> checkedPossibleValues = new ArrayList<>();
        for (int d = 0; d <= 9; d++) {
            if (possibleValues.get(d) > 0) {
                checkedPossibleValues.add(possibleValues.get(d));
            }
        }
        //then
        Assert.assertEquals(4, checkedPossibleValues.size());
        Assert.assertEquals(5, checkedPossibleValues.get(0).intValue());
        Assert.assertEquals(6, checkedPossibleValues.get(1).intValue());
        Assert.assertEquals(7, checkedPossibleValues.get(2).intValue());
        Assert.assertEquals(8, checkedPossibleValues.get(3).intValue());
    }

    @Test
    public void checkColumn() {
        //given
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(1).setValue(4);
        sudokuBoard.getSudokuRow(4).get(1).setValue(5);
        sudokuBoard.getSudokuRow(5).get(1).setValue(6);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibleValues = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, 6, 1);
        //when
        List<Integer> checkedPossibleValues = new ArrayList<>();
        for (int d = 0; d <= 9; d++) {
            if (possibleValues.get(d) > 0) {
                checkedPossibleValues.add(possibleValues.get(d));
            }
        }
        //then
        Assert.assertEquals(3, checkedPossibleValues.size());
    }

    @Test
    public void checkRows() {
        //given
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(1).get(4).setValue(4);
        sudokuBoard.getSudokuRow(1).get(5).setValue(5);
        sudokuBoard.getSudokuRow(1).get(6).setValue(6);
        sudokuBoard.getSudokuRow(1).get(7).setValue(7);
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibleValues = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, 1, 8);
        //when
        List<Integer> checkedPossibleValues = new ArrayList<>();
        for (int d = 0; d <= 9; d++) {
            if (possibleValues.get(d) > 0) {
                checkedPossibleValues.add(possibleValues.get(d));
            }
        }
        //then
        Assert.assertEquals(3, checkedPossibleValues.size());
    }

}