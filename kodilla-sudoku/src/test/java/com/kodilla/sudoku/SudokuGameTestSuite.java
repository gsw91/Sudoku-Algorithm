package com.kodilla.sudoku;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.Board.SudokuRow;
import com.kodilla.sudoku.SetupGame.GameConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SudokuGameTestSuite {

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
        ArrayList<SudokuElement> elements = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            elements.add(new SudokuElement(SudokuElement.EMPTY));
        }
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