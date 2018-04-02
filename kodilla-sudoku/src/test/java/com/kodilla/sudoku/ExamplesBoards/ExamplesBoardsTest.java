package com.kodilla.sudoku.ExamplesBoards;

import com.kodilla.sudoku.Board.SudokuBoard;
import org.junit.Test;

public class ExamplesBoardsTest {

    @Test
    public void getBoardLevelMediumOne() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelMediumOne();
        //when

        //then
        System.out.println(sudokuBoard);
    }

    @Test
    public void getBoardLevelHardOne() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelhardOne();
        //when

        //then
        System.out.println(sudokuBoard);
    }

}