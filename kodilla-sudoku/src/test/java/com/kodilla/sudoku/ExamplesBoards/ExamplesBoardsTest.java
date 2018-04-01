package com.kodilla.sudoku.ExamplesBoards;

import com.kodilla.sudoku.Board.SudokuBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExamplesBoardsTest {

    @Test
    public void getBoardLevelMedium() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelMedium();
        //when

        //then
        System.out.println(sudokuBoard);
    }
}