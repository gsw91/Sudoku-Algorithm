package com.sudoku.ExamplesBoards;


import com.sudoku.Board.SudokuBoard;

public class ExamplesBoards {

    public SudokuBoard getBoardWithoutSolution(){
        //my own
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(9);
        sudokuBoard.getSudokuRow(2).get(4).setValue(9);
        sudokuBoard.getSudokuRow(3).get(7).setValue(9);
        sudokuBoard.getSudokuRow(4).get(2).setValue(9);
        sudokuBoard.getSudokuRow(5).get(5).setValue(9);
        sudokuBoard.getSudokuRow(6).get(8).setValue(9);
        sudokuBoard.getSudokuRow(7).get(3).setValue(9);
        sudokuBoard.getSudokuRow(8).get(6).setValue(9);
        sudokuBoard.getSudokuRow(9).get(9).setValue(1);
        sudokuBoard.getSudokuRow(9).get(8).setValue(2);
        sudokuBoard.getSudokuRow(9).get(7).setValue(3);
        sudokuBoard.getSudokuRow(8).get(9).setValue(4);
        sudokuBoard.getSudokuRow(8).get(8).setValue(5);
        sudokuBoard.getSudokuRow(8).get(7).setValue(6);
        sudokuBoard.getSudokuRow(7).get(9).setValue(7);
        sudokuBoard.getSudokuRow(7).get(8).setValue(8);

        return sudokuBoard;
    }

    public SudokuBoard getBoardLevelVeryHardOne() {
        //board very hard no 1 from http://www.sudoku.neat.pl/sudoku_bighd.html
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();
        sudokuBoard.getSudokuRow(1).get(2).setValue(1);
        sudokuBoard.getSudokuRow(1).get(3).setValue(4);
        sudokuBoard.getSudokuRow(1).get(4).setValue(2);
        sudokuBoard.getSudokuRow(1).get(7).setValue(5);
        sudokuBoard.getSudokuRow(2).get(1).setValue(6);
        sudokuBoard.getSudokuRow(2).get(4).setValue(5);
        sudokuBoard.getSudokuRow(2).get(8).setValue(9);
        sudokuBoard.getSudokuRow(3).get(4).setValue(4);
        sudokuBoard.getSudokuRow(3).get(5).setValue(8);
        sudokuBoard.getSudokuRow(3).get(6).setValue(3);
        sudokuBoard.getSudokuRow(4).get(4).setValue(1);
        sudokuBoard.getSudokuRow(4).get(6).setValue(9);
        sudokuBoard.getSudokuRow(4).get(8).setValue(5);
        sudokuBoard.getSudokuRow(4).get(9).setValue(3);
        sudokuBoard.getSudokuRow(5).get(3).setValue(8);
        sudokuBoard.getSudokuRow(5).get(4).setValue(6);
        sudokuBoard.getSudokuRow(5).get(6).setValue(2);
        sudokuBoard.getSudokuRow(6).get(3).setValue(9);
        sudokuBoard.getSudokuRow(6).get(8).setValue(1);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        sudokuBoard.getSudokuRow(8).get(7).setValue(3);
        sudokuBoard.getSudokuRow(8).get(9).setValue(2);
        sudokuBoard.getSudokuRow(9).get(3).setValue(3);
        sudokuBoard.getSudokuRow(9).get(8).setValue(4);
        sudokuBoard.getSudokuRow(9).get(9).setValue(9);

        return sudokuBoard;
    }

    public SudokuBoard getBoardLevelhardOne() {
        //board hard no 1 from http://www.gim2.lubliniec.pl/sudoku/plansze.htm
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(8);
        sudokuBoard.getSudokuRow(1).get(5).setValue(3);
        sudokuBoard.getSudokuRow(1).get(8).setValue(4);
        sudokuBoard.getSudokuRow(2).get(6).setValue(9);
        sudokuBoard.getSudokuRow(2).get(9).setValue(5);
        sudokuBoard.getSudokuRow(3).get(2).setValue(5);
        sudokuBoard.getSudokuRow(3).get(3).setValue(1);
        sudokuBoard.getSudokuRow(3).get(6).setValue(6);
        sudokuBoard.getSudokuRow(3).get(8).setValue(3);
        sudokuBoard.getSudokuRow(4).get(3).setValue(5);
        sudokuBoard.getSudokuRow(4).get(5).setValue(4);
        sudokuBoard.getSudokuRow(4).get(9).setValue(9);
        sudokuBoard.getSudokuRow(5).get(1).setValue(9);
        sudokuBoard.getSudokuRow(5).get(4).setValue(1);
        sudokuBoard.getSudokuRow(5).get(6).setValue(2);
        sudokuBoard.getSudokuRow(5).get(9).setValue(4);
        sudokuBoard.getSudokuRow(6).get(1).setValue(2);
        sudokuBoard.getSudokuRow(6).get(7).setValue(3);
        sudokuBoard.getSudokuRow(7).get(2).setValue(3);
        sudokuBoard.getSudokuRow(7).get(4).setValue(7);
        sudokuBoard.getSudokuRow(7).get(7).setValue(6);
        sudokuBoard.getSudokuRow(7).get(8).setValue(8);
        sudokuBoard.getSudokuRow(7).get(9).setValue(1);
        sudokuBoard.getSudokuRow(8).get(1).setValue(1);
        sudokuBoard.getSudokuRow(8).get(4).setValue(9);
        sudokuBoard.getSudokuRow(9).get(2).setValue(7);
        sudokuBoard.getSudokuRow(9).get(5).setValue(8);

        return sudokuBoard;
    }

    public SudokuBoard getBoardLevelMediumOne() {
        //board medium no 1 from http://www.gim2.lubliniec.pl/sudoku/plansze.htm
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();
        sudokuBoard.getSudokuRow(1).get(1).setValue(3);
        sudokuBoard.getSudokuRow(1).get(5).setValue(4);
        sudokuBoard.getSudokuRow(1).get(7).setValue(2);
        sudokuBoard.getSudokuRow(2).get(1).setValue(2);
        sudokuBoard.getSudokuRow(2).get(2).setValue(5);
        sudokuBoard.getSudokuRow(2).get(6).setValue(3);
        sudokuBoard.getSudokuRow(2).get(7).setValue(7);
        sudokuBoard.getSudokuRow(2).get(8).setValue(4);
        sudokuBoard.getSudokuRow(3).get(3).setValue(4);
        sudokuBoard.getSudokuRow(3).get(5).setValue(5);
        sudokuBoard.getSudokuRow(3).get(6).setValue(1);
        sudokuBoard.getSudokuRow(3).get(8).setValue(8);
        sudokuBoard.getSudokuRow(4).get(2).setValue(3);
        sudokuBoard.getSudokuRow(4).get(5).setValue(6);
        sudokuBoard.getSudokuRow(4).get(7).setValue(9);
        sudokuBoard.getSudokuRow(4).get(9).setValue(7);
        sudokuBoard.getSudokuRow(5).get(2).setValue(4);
        sudokuBoard.getSudokuRow(5).get(4).setValue(8);
        sudokuBoard.getSudokuRow(5).get(6).setValue(7);
        sudokuBoard.getSudokuRow(6).get(2).setValue(6);
        sudokuBoard.getSudokuRow(6).get(6).setValue(5);
        sudokuBoard.getSudokuRow(6).get(7).setValue(4);
        sudokuBoard.getSudokuRow(6).get(8).setValue(2);
        sudokuBoard.getSudokuRow(7).get(1).setValue(7);
        sudokuBoard.getSudokuRow(7).get(5).setValue(2);
        sudokuBoard.getSudokuRow(7).get(6).setValue(8);
        sudokuBoard.getSudokuRow(7).get(7).setValue(6);
        sudokuBoard.getSudokuRow(8).get(2).setValue(9);
        sudokuBoard.getSudokuRow(8).get(4).setValue(3);
        sudokuBoard.getSudokuRow(8).get(8).setValue(5);
        sudokuBoard.getSudokuRow(8).get(9).setValue(2);
        sudokuBoard.getSudokuRow(9).get(1).setValue(4);
        sudokuBoard.getSudokuRow(9).get(2).setValue(2);
        sudokuBoard.getSudokuRow(9).get(5).setValue(1);
        sudokuBoard.getSudokuRow(9).get(8).setValue(7);

        return sudokuBoard;
    }

}
