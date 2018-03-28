package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.SetupGame.GameConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckingSudokuFieldsTest {

    @Test
    public void checkColumn() {
        //given
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(3).get(1).setValue(4);
        sudokuBoard.getSudokuRow(4).get(1).setValue(5);
        sudokuBoard.getSudokuRow(5).get(1).setValue(6);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);

        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValues = sudokuElement.getPossibleValues();
        //when
        checkingSudokuFields.checkColumn(sudokuBoard, possibleValues, 6, 1);

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
        GameConfiguration gameConfiguration = new GameConfiguration();
        SudokuBoard sudokuBoard = gameConfiguration.createBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(1);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(1).get(4).setValue(4);
        sudokuBoard.getSudokuRow(1).get(5).setValue(5);
        sudokuBoard.getSudokuRow(1).get(6).setValue(6);
        sudokuBoard.getSudokuRow(1).get(7).setValue(7);
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValues = sudokuElement.getPossibleValues();
        //when
        checkingSudokuFields.checkRow(sudokuBoard, possibleValues, 1, 8);
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