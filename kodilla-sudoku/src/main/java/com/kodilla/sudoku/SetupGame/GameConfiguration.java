package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.ExamplesBoards.ExamplesBoards;
import com.kodilla.sudoku.SudokuAlgorithms.CheckingSudokuFields;
import com.kodilla.sudoku.RandomForTests.RandomBoardForTesting;
import com.kodilla.sudoku.SudokuAlgorithms.ValuesElimination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    private Scanner scanner = new Scanner(System.in);
    private List<SudokuBoard> sudokuBoardsSaves = new ArrayList<>();

    public SudokuBoard loadLastSavedCopy() throws IndexOutOfBoundsException {

        if (sudokuBoardsSaves.size()>0) {
            int index = sudokuBoardsSaves.size() - 1;
            return sudokuBoardsSaves.get(index);
        } else if (sudokuBoardsSaves.size()==0) {
            System.out.println("Sudoku board is incorrect, please fill it one more time\n");
            System.out.println("Press enter");
            scanner.nextLine();
            sudokuWelcome();
            return fortifyBoardWithFigures();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void deepCopyInGame(SudokuBoard sudokuBoard) {
        SudokuBoard deepCopy = makeDeepCopyOfBoard(sudokuBoard);
        sudokuBoardsSaves.add(deepCopy);
    }

    private SudokuBoard makeDeepCopyOfBoard(SudokuBoard sudokuBoard) {
        SudokuBoard deepCopy = null;
        try {
            deepCopy = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage() + e);
        }

        return deepCopy;
    }

    public void sudokuWelcome() {
        System.out.println("Welcome in Sudoku! \n" +
                "Press enter to insert new value into board.\n" +
                "Command RANDOM completes the board with 20 figures and begins the game. \n" +
                "Command GET MEDIUM returns ready board level medium \n" +
                "Command GET HARD returns ready board level hard" +
                "Command SUDOKU begins the game.\n");
    }

    public int insertValues(SudokuBoard sudokuBoard) {
        SudokuBoard deepCopyOfSudokuBoard = loadLastSavedCopy();
        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        ValuesElimination elimination = new ValuesElimination();
        int countInsertedValues = 1;
        int countRoundsOfAlgorithm = 0;
        while (countInsertedValues > 0) {
            countRoundsOfAlgorithm++;
            countInsertedValues = 0;
            for (int row = 1; row <= 9; row++) {
                for (int column = 1; column <= 9; column++) {
                    countInsertedValues = checkingSudokuFields.tryInsertValueIntoField(sudokuBoard, row, column, countInsertedValues, deepCopyOfSudokuBoard);
                    if (countInsertedValues == 0) {
                        countInsertedValues = elimination.insertValueByElimination(sudokuBoard, row, column);
                    }
                }
            }
            if (countInsertedValues > 0) {
                System.out.println("    Round: " + countRoundsOfAlgorithm + ", inserted values: " + countInsertedValues + "\n");
                System.out.println("Current sudoku board after inserting value: \n" + sudokuBoard);
            }
        }
        return countInsertedValues;
    }


    public SudokuBoard fortifyBoardWithFigures () {

        int howManyElementsInsert = 81;
        int x = 0;
        SudokuBoard sudokuBoard = createBoard();
        ExamplesBoards examplesBoards = new ExamplesBoards();

        while (x < howManyElementsInsert) {
            try {
                String command = scanner.nextLine();
                switch (command) {
                    case "SUDOKU":
                        x=howManyElementsInsert;
                        break;
                    case "RANDOM":
                        RandomBoardForTesting randomBoardForTesting = new RandomBoardForTesting();
                        int quantity = 20;
                        randomBoardForTesting.createRandomBoard(sudokuBoard, quantity);
                        x=howManyElementsInsert;
                        break;
                    case "GET MEDIUM":
                        sudokuBoard = examplesBoards.getBoardLevelMediumOne();
                        x=howManyElementsInsert;
                        break;
                    case "GET HARD":
                        sudokuBoard = examplesBoards.getBoardLevelMediumOne();
                        x=howManyElementsInsert;
                        break;
                    default:
                        insertOneElement(sudokuBoard);
                        x++;
                        System.out.println("\n Press enter to insert new value into board.\n");
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
        return sudokuBoard;
    }

    public void insertOneElement(SudokuBoard sudokuBoard) {
        deepCopyInGame(sudokuBoard);
        try {
            insertElement(sudokuBoard);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value");
        }
        System.out.println("Current sudoku board: \n" + sudokuBoard);
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

        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibilities = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, row, column);
        System.out.println("Possible values for this field: " + checkingSudokuFields.addPossibilitiesToNewList(possibilities));
        if(checkingSudokuFields.addPossibilitiesToNewList(possibilities).size()==0) {
            throw new NumberFormatException();
        }


        System.out.println("\n Insert value");
        String getValue = scanner.nextLine();
        int value;
        if (Integer.parseInt(getValue) > 0 && Integer.parseInt(getValue) < 10 && possibilities.indexOf(Integer.parseInt(getValue)) > 0) {
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

