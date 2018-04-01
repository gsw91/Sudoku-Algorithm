package com.kodilla.sudoku;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.Board.SudokuRow;
import com.kodilla.sudoku.SudokuAlgorithms.CheckingSudokuFields;
import com.kodilla.sudoku.RandomForTests.RandomBoardForTesting;
import com.kodilla.sudoku.SetupGame.GameConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SudokuGameTestSuite {

    @Test
    public void testRestartGameIfFinished() {
        //given

        //when
        //then
    }

    @Test
    public void testInsertRandomValues() {
        //given
        System.out.println("Test: Insert 40 random values into sudoku board");
        GameConfiguration gameConfiguration = new GameConfiguration();
        RandomBoardForTesting randomBoardForTesting = new RandomBoardForTesting();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        randomBoardForTesting.createRandomBoard(sudokuBoard, 40);
        //when
        int allValues = randomBoardForTesting.countInsertedValues(sudokuBoard);
        //then
        Assert.assertEquals(40, allValues );
        System.out.println(sudokuBoard);
    }


    @Test
    public void testValueInsertionIntoColumn() {
        //given
        System.out.println("Test: Insert missing values into column one");
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        //when
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(1).setValue(3);
        sudokuBoard.getSudokuRow(4).get(1).setValue(4);
        sudokuBoard.getSudokuRow(5).get(1).setValue(5);
        sudokuBoard.getSudokuRow(6).get(1).setValue(6);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        sudokuBoard.getSudokuRow(8).get(4).setValue(9);
        System.out.println("Begining board: \n" + sudokuBoard);
        gameConfiguration.insertValues(sudokuBoard);
        int expectedValue = sudokuBoard.getSudokuRow(9).get(1).getValue();
        //then
        System.out.println("Current board: \n" + sudokuBoard);
        Assert.assertEquals(9, expectedValue);


    }

    @Test
    public void testValueInsertionIntoRow() {
        //given
        System.out.println("Test: Insert missing value into row one");
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        //when
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(1).get(3).setValue(3);
        sudokuBoard.getSudokuRow(1).get(4).setValue(4);
        sudokuBoard.getSudokuRow(1).get(5).setValue(5);
        sudokuBoard.getSudokuRow(1).get(6).setValue(6);
        sudokuBoard.getSudokuRow(1).get(7).setValue(7);
        sudokuBoard.getSudokuRow(4).get(8).setValue(9);
        System.out.println("Begining board: \n" + sudokuBoard);
        gameConfiguration.insertValues(sudokuBoard);
        int expectedValue = sudokuBoard.getSudokuRow(1).get(9).getValue();
        //then
        System.out.println("Current board: \n" + sudokuBoard);
        Assert.assertEquals(9, expectedValue);
    }

    @Test
    public void testValueInsertionIntoSectionOne() {
        //given
        System.out.println("Test: Insert missing value into section one");
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        //when
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(1).get(3).setValue(3);
        sudokuBoard.getSudokuRow(2).get(1).setValue(4);
        sudokuBoard.getSudokuRow(2).get(2).setValue(5);
        sudokuBoard.getSudokuRow(2).get(3).setValue(6);
        sudokuBoard.getSudokuRow(3).get(1).setValue(7);
        sudokuBoard.getSudokuRow(3).get(2).setValue(8);
        System.out.println("Begining board: \n" + sudokuBoard);
        gameConfiguration.insertValues(sudokuBoard);
        int expectedValue = sudokuBoard.getSudokuRow(3).get(3).getValue();
        //then
        System.out.println("Current board: \n" + sudokuBoard);
        Assert.assertEquals(9, expectedValue);

    }

    @Test
    public void testCheckSectionOne() {
        //given
        System.out.println("Test: Check section one");
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        CheckingSudokuFields checkingSudokuFields;
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValues = sudokuElement.getPossibleValues();
        //when
        sudokuBoard.getSudokuRow(1).get(3).setValue(6);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(2).setValue(5);
        checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        //then
        System.out.println("Board: \n" + sudokuBoard);
        for(int row=1; row<4; row++) {
            for (int column = 1; column < 4; column++) {
                checkingSudokuFields.checkSections(sudokuBoard, possibleValues, row, column);
                checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, row, column);
            }
        }
    }

    @Test
    public void testCheckPossibleValuesInSudokuElement(){
        //given
        System.out.println("Test: Check possible elements in SudokuElement");
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> elements = sudokuElement.getPossibleValues();
        //when
        //then
        System.out.println("All possible values in sudoku element:");
        System.out.println(elements);
        System.out.println("index: value: " );
        for(int value = 0; value <=9; value++) {
            System.out.println(value + "      " + elements.get(value));
        }
    }


    @Test
    public void testShowEmptyBoard() {
        //given
        System.out.println("Test: Creating new board");
        GameConfiguration gameConfiguration = new GameConfiguration();
        //when
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        //then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testInsertValueIntoRow() {
        //given
        System.out.println("Test: Adding new value into sudoku row");
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.createRow();
        //when
        sudokuRow.getElements().get(2).setValue(2);
        int value1 = sudokuRow.getElements().get(2).getValue();
        int value2 = sudokuRow.getElements().get(3).getValue();
        int value3 = sudokuRow.getElements().get(9).getValue();
        //then
        Assert.assertEquals(2, value1);
        Assert.assertEquals(-1, value2);
        Assert.assertEquals(-1, value3);
        System.out.println(sudokuRow);
    }

    @Test
    public void testInsertValueIntoBoard() {
        //given
        System.out.println("Test: Adding three new values into sudoku board");
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        //when
        sudokuBoard.getSudokuRow(4).get(3).setValue(6);
        sudokuBoard.getSudokuRow(5).get(6).setValue(2);
        sudokuBoard.getSudokuRow(3).get(2).setValue(5);
        int value1 = sudokuBoard.getSudokuRow(4).get(3).getValue();
        int value2 = sudokuBoard.getSudokuRow(5).get(6).getValue();
        int value3 = sudokuBoard.getSudokuRow(3).get(2).getValue();
        int value4 = sudokuBoard.getSudokuRow(2).get(3).getValue();
        //then
        Assert.assertEquals(6, value1);
        Assert.assertEquals(2, value2);
        Assert.assertEquals(5, value3);
        Assert.assertEquals(-1, value4);
        System.out.println(sudokuBoard);
    }


}