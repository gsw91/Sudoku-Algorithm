package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;
import com.kodilla.sudoku.CheckingAlgorithms.CheckingSections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    private Scanner scanner = new Scanner(System.in);

    public void checkPossibleFigures(SudokuBoard sudokuBoard) {
        CheckingSections checkingSections = new CheckingSections(sudokuBoard);
        ValuesInsertionCondition valuesInsertionCondition;
        SudokuElement sudokuElement;
        List<Integer> possibleValues;
        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
                    sudokuElement = new SudokuElement();
                    possibleValues = sudokuElement.getPossibleValues();
                    for (int value = 1; value <= 9; value++) {
                        for (int i = 1; i <= 9; i++) {
                            if (possibleValues.get(value) == sudokuBoard.getSudokuRow(row).get(i).getValue()) {
                                possibleValues.set(value, -1);
                            } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(column).getValue()) {
                                possibleValues.set(value, -1);
                            }
                            checkingSections.checkAllSections(sudokuBoard, possibleValues,value, row, column, i);
                        }
                    }
                    List<Integer> possibilities = new ArrayList<>();
                    for (int d = 0; d <= 9; d++) {
                        if (possibleValues.get(d) > 0) {
                            possibilities.add(possibleValues.get(d));
                        }
                    }

                    System.out.println("Possible values " + possibilities.size() + " for row: " + row + ", column: " + column + ", " + possibilities);
                    valuesInsertionCondition = new ValuesInsertionCondition(possibilities, sudokuBoard, row, column);
                    valuesInsertionCondition.tryInsertValue();


                } else if (sudokuBoard.getSudokuRow(row).get(column).getValue() != -1) {
                    System.out.println("Row: " + row + ", column: " + column + ", inserted");
                }
            }
        }
        System.out.println(sudokuBoard);
    }

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

