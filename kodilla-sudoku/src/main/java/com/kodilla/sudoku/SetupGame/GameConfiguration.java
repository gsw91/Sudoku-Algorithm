package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.CheckingAlgorithms.CheckingSudokuFields;
import com.kodilla.sudoku.RandomForTests.RandomBoardForTesting;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    private Scanner scanner = new Scanner(System.in);

    public void checkPossibleFiguresAndInsert(SudokuBoard sudokuBoard) {
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        SudokuElement sudokuElement;
        List<Integer> possibleValues;
        int countInsertedValues = 1;
        while (countInsertedValues > 0) {
            countInsertedValues = 0;
            for (int row = 1; row <= 9; row++) {
                for (int column = 1; column <= 9; column++) {
                    sudokuElement = new SudokuElement();
                    possibleValues = sudokuElement.getPossibleValues();
                    countInsertedValues = checkingSudokuFields.checkAllFields(sudokuBoard, row, column, possibleValues, countInsertedValues);
                }
            }
            System.out.println("    Inserted values: " + countInsertedValues + "\n");
        }
        System.out.println("Curent board: \n" + sudokuBoard);
    }


    public void fortifyBoardWithFigures (SudokuBoard sudokuBoard) {

        System.out.println("Welcome in Sudoku! \n" +
                "First, complete the sudoku board with numbers.\n" +
                "Command SUDOKU begins the game.\n" +
                "Command RANDOM completes the board up to 20 figures and begins the game. \n");

        int howManyElementsInsert = 81;
        int x = 0;

        while (x < howManyElementsInsert) {
            try {
                System.out.println("Press enter to insert new value, SUDOKU, or RANDOM.\n");
                String command = scanner.nextLine();
                if (command.equals("SUDOKU")) {
                    break;
                } else if (command.equals("RANDOM")) {
                    RandomBoardForTesting randomBoardForTesting = new RandomBoardForTesting();
                    int quantity = 20-x;
                    randomBoardForTesting.createRandomBoard(sudokuBoard, quantity);
                    break;
                } else {
                    insertElement(sudokuBoard);
                    x++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value. \n" +
                        "Try one more time.\n");
            }
        }
        System.out.println("Your board: ");
        System.out.println(sudokuBoard);
        System.out.println("Press enter to start the game");
        scanner.nextLine();
    }

    public void insertOneElement(SudokuBoard sudokuBoard) {

        try {
            insertElement(sudokuBoard);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value");
        }
    }

    private void insertElement(SudokuBoard sudokuBoard) throws NumberFormatException {

        List<Integer> possibleValuesList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            possibleValuesList.add(i);
        }

        System.out.println("\n Insert column");
        String getColumn = scanner.nextLine();
        int column;
        if (Integer.parseInt(getColumn) > 0 && Integer.parseInt(getColumn) < 10) {
            column = Integer.parseInt(getColumn);
        } else {
            throw new NumberFormatException();
        }

        System.out.println("\n Insert row");
        String getRow = scanner.nextLine();
        int row;
        if (Integer.parseInt(getRow) > 0 && Integer.parseInt(getRow) < 10) {
            row = Integer.parseInt(getRow);
        } else {
            throw new NumberFormatException();
        }
        System.out.println("\n Insert value");
        String getValue = scanner.nextLine();
        int value;
        if (Integer.parseInt(getValue) > 0 && Integer.parseInt(getValue) < 10) {
            value = Integer.parseInt(getValue);
        } else {
            throw new NumberFormatException();
        }

        if (column > 0 && column < 10 && possibleValuesList.get(column) == column) {
            if (row > 0 && row < 10 && possibleValuesList.get(row) == row) {
                if (value > 0 && value <= 9) {
                    sudokuBoard.getSudokuRow(row).get(column).setValue(value);
                    System.out.println("Value added. \n");
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }


    public SudokuBoard createBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.createNewBoard();

        return sudokuBoard;

    }


}

