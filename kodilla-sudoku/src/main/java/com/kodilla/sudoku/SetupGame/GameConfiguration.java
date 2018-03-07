package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    Scanner scanner = new Scanner(System.in);


    public SudokuBoard fortifyBoardWithFigures (SudokuBoard sudokuBoard) {

        System.out.println("Ile cyfr chcesz wprowadzić do tablicy ?");
        int quantity = scanner.nextInt();

        int x = 0;
        while (x < quantity) {
            try {
                insertElement(sudokuBoard);
                x += 1;
            } catch (SudokuElementException e) {
                System.out.println("Wrong value");
            }
            System.out.println(sudokuBoard);
        }

        return sudokuBoard;
    }


    public SudokuBoard insertElement(SudokuBoard sudokuBoard) throws SudokuElementException {

        List<Integer> possibleValuesList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            possibleValuesList.add(i);
        }

        System.out.println("\n Insert column");
        int column = scanner.nextInt();
        System.out.println("\n Insert row");
        int row = scanner.nextInt();
        System.out.println("\n Insert value");
        int value = scanner.nextInt();

        if (column > 0 && column < 10 && possibleValuesList.get(column) == column) {
            if (row > 0 && row < 10 && possibleValuesList.get(row) == row) {
                if (value > 0 && value <= 9) {
                    sudokuBoard.getSudokuRow(row).get(column).setValue(value);
                } else {
                    throw new SudokuElementException();
                }
            } else {
                throw new SudokuElementException();
            }
        } else {
            throw new SudokuElementException();
        }

        return sudokuBoard;
    }


    public SudokuBoard createBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();

        return sudokuBoard;

    }


}

