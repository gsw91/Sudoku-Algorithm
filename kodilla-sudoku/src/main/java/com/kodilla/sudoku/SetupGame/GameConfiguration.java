package com.kodilla.sudoku.SetupGame;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    private Scanner scanner = new Scanner(System.in);

    public void checkPossibleFigures(SudokuBoard sudokuBoard) {
        CheckSection checkSection;
        ValuesInsertionCondition valuesInsertionCondition;
        SudokuElement sudokuElement;
        List<Integer> possibleValues;
        List<Integer> valueToInsert;
        for (int i = 1; i <= 9; i++) {
            for (int n = 1; n <= 9; n++) {
                if (sudokuBoard.getSudokuRow(i).get(n).getValue() == -1) {
                    sudokuElement = new SudokuElement();
                    possibleValues = sudokuElement.getPossibleValues();
                    for (int value = 1; value <= 9; value++) {
                        for (int k = 1; k <= 9; k++) {
                            if (possibleValues.get(value) == sudokuBoard.getSudokuRow(i).get(k).getValue()) {
                                possibleValues.set(value, -1);
                            } else if (possibleValues.get(value) == sudokuBoard.getSudokuRow(k).get(n).getValue()) {
                                possibleValues.set(value, -1);
                            }
                            if (i<4 && k<4 && n<4) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionOne(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i<4 && k>=4 && k<7 && n>=4 && n<7) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionTwo(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i<4 && k>=7 && n>=7) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionThree(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=4 && i<=6 && k<4 && n<4) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionFour(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=4 && i<=6 && k>=4 && k<=6 && n>=4 && n<=6) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionFive(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=4 && i<=6 && k>=7 && n>=7) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionSix(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=7 && k<=3 && n<=3) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionSeven(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=7 && k>=4 && k<=6 && n>=4 && n<=6) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionEight(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                            if (i>=7 && k>=7 && n>=7) {
                                checkSection = new CheckSection(sudokuBoard);
                                List<Integer> selectedValues = checkSection.checkSectionNine(possibleValues);
                                for (int val = 0; val < 10; val++) {
                                    if (selectedValues.get(val) != possibleValues.get(val)) {
                                        possibleValues.set(value, -1);
                                    }
                                }
                            }

                        }
                    }
                    List<Integer> possibilities = new ArrayList<>();
                    for (int d = 0; d <= 9; d++) {
                        if (possibleValues.get(d) > 0) {
                            possibilities.add(possibleValues.get(d));
                        }
                    }

                    System.out.println("Possible values " + possibilities.size() + " for row: " + i + ", column: " + n + ", " + possibilities);
                    valuesInsertionCondition = new ValuesInsertionCondition(possibilities, sudokuBoard, i, n);
                    valuesInsertionCondition.tryInsertValue();


                } else if (sudokuBoard.getSudokuRow(i).get(n).getValue() != -1) {
                    System.out.println("Row: " + i + ", column: " + n + ", inserted");
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

