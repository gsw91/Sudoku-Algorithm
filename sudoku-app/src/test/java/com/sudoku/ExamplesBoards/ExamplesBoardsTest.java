package com.sudoku.ExamplesBoards;

import com.sudoku.Board.SudokuBoard;
import com.sudoku.Board.SudokuElement;
import org.junit.Test;

import java.util.List;

public class ExamplesBoardsTest {

    @Test
    public void getBoardWithoutSolution() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardWithoutSolution();
        //when

        //then
        System.out.println(sudokuBoard);
    }

    @Test
    public void getBoardLevelMediumOne() {
        //given
        ExamplesBoards examplesBoards = new ExamplesBoards();
        SudokuBoard sudokuBoard = examplesBoards.getBoardLevelMediumOne();
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> values = sudokuElement.getPossibleValues();
        //when

        //then
        System.out.println(sudokuBoard);
        System.out.println("Possible values: " + values);
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