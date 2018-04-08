package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.ExamplesBoards.ExamplesBoards;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GameConfigurationTest {

    @Ignore
    @Test
    public void makeDeepCopyOfBoard() {
        //given
        //GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelhardOne();
        //when
        //gameConfiguration.deepCopyInGame(sudokuBoard, 1, 2, 2);
        sudokuBoard.getSudokuRow(1).get(2).setValue(2);
        sudokuBoard.getSudokuRow(2).get(1).setValue(3);
        //SudokuBoard clonedBoard = gameConfiguration.loadLastSavedCopy();
        //then
        //Assert.assertEquals(-1, clonedBoard.getSudokuRow(1).get(2).getValue());
        //Assert.assertEquals(-1, clonedBoard.getSudokuRow(2).get(1).getValue());
        Assert.assertEquals(2, sudokuBoard.getSudokuRow(1).get(2).getValue());
        Assert.assertEquals(3, sudokuBoard.getSudokuRow(2).get(1).getValue());
        //else
        //sudokuBoard = gameConfiguration.loadLastSavedCopy();
        Assert.assertEquals(-1, sudokuBoard.getSudokuRow(1).get(2).getValue());
        Assert.assertEquals(-1, sudokuBoard.getSudokuRow(2).get(1).getValue());

    }
}