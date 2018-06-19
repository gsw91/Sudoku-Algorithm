package com.sudoku.SetupGame;



import com.sudoku.Board.SudokuBoard;
import com.sudoku.Board.SudokuElement;
import com.sudoku.Board.SudokuException;
import com.sudoku.ExamplesBoards.ExamplesBoards;
import com.sudoku.Prototype.SudokuBoardCopy;
import com.sudoku.RandomForTests.RandomBoard;
import com.sudoku.SudokuAlgorithms.CheckingSudokuFields;
import com.sudoku.SudokuAlgorithms.ValuesElimination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameConfiguration {

    private static GameConfiguration gameConfigurationInstance = null;
    private Scanner scanner = new Scanner(System.in);
    private List<SudokuBoardCopy> backtrack = new ArrayList<>();
    private int countedMistakes = 0;

    private GameConfiguration() {}

    public static GameConfiguration getInstance() {
        if (gameConfigurationInstance == null) {
            gameConfigurationInstance = new GameConfiguration();
        }
        return gameConfigurationInstance;
    }

    public void run() {
        restartGame();
    }

    private void restartGame() {

        // Tworzenie tablicy
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        backtrack.clear();

        // Powitanie i wprowadzenie cyfr, pierwsza kopia tablicy
        SudokuBoard sudokuBoard = gameConfiguration.initializingApp();

        boolean gameFinished = false;
        while (!gameFinished) {

            //Sprawdzanie możliwych liczb do wprowadzenia i wprowadzenie, ewentualnie błąd
            SudokuBoard sudokuBoard1 = gameConfiguration.insertValues(sudokuBoard);
            SudokuBoard copiedBoard = loadLastSavedCopy();

            int score = 0;
            int emptyBoardCheck = 0;
            for (int row = 1; row < 10; row++) {
                for (int column = 1; column < 10; column++) {
                    if (sudokuBoard1.getSudokuRow(row).get(column).getValue() == copiedBoard.getSudokuRow(row).get(column).getValue()) {
                        score++;
                    }
                    if (sudokuBoard1.getSudokuRow(row).get(column).getValue() > 0 ) {
                        emptyBoardCheck++;
                    }
                }
            }

            if (emptyBoardCheck == 0) {
                System.out.println("Your board is empty! Create new one. \n");
                gameFinished= true;
                restartGame();
            }

            if (score == 81) {
                sudokuBoard = copiedBoard;
            }

            //Warunek zakończenia gry
            List<Integer> endingGame = new ArrayList<>();
            for (int row = 1; row < 10; row++) {
                for (int column = 1; column < 10; column++) {
                    if (sudokuBoard.getSudokuRow(row).get(column).getValue() < 0) {
                        endingGame.add(sudokuBoard.getSudokuRow(row).get(column).getValue());
                    }
                }
            }
            if (endingGame.size() == 0) {
                System.out.println("Board is filled. The end.\n" +
                        "Press any key to quit or write R to restart app.");
                String decision = scanner.nextLine();

                switch (decision) {
                    case "R":
                        backtrack.clear();
                        restartGame();
                    default:
                        gameFinished = true;
                        System.exit(0);
                }
            } else {
                //Wprowadzanie ręcznie liczb
                try {
                    System.out.println("Please insert new value by hand, algorithm sees no possibilities!\n");
                    gameConfiguration.insertOneElement(sudokuBoard);
                } catch (NumberFormatException e) {
                    System.out.println("Insert correct values \n");
                }
            }
        }
    }

    private SudokuBoard initializingApp() {
        sudokuWelcome();
        SudokuBoard sudokuBoard = fortifyBoardWithFigures();
        deepCopyInGame(sudokuBoard, 0, 0, 0);
        return sudokuBoard;
    }

    public SudokuBoard insertValues(SudokuBoard sudokuBoard) {
        ValuesElimination elimination = new ValuesElimination();
        boolean isEmpty = false;
        int count;
        while (!isEmpty) {
            count = 0;
            for (int row = 1; row <= 9; row++) {
                for (int column = 1; column <= 9; column++) {
                    if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
                        try {
                            tryInsertValueIntoField(sudokuBoard, row, column);
                        } catch (SudokuException e) {
                            System.out.println("There is an value mistaken in sudoku board. \n");
                            countedMistakes++;
                            if (countedMistakes > 3) {
                                System.out.println("Sudoku impossible to complete, create new board\n");
                                restartGame();
                            }
                            if (backtrack.size()==1) {
                                System.out.println("This sudoku is impossible to complete, create new board\n");
                                restartGame();
                            }
                            System.out.println("Press enter to come back to previous decision.\n");
                            scanner.nextLine();
                            sudokuBoard = loadLastSavedCopy();
                            removeValueFromPossiblities(sudokuBoard);
                            return sudokuBoard;
                        }
                        if (sudokuBoard.getSudokuRow(row).get(column).getValue() == -1) {
                            elimination.insertValueByElimination(sudokuBoard, row, column);
                            if(sudokuBoard.getSudokuRow(row).get(column).getValue() > 0) {
                                count++;
                            }
                        } else {
                            count++;
                        }
                    }
                }
            }
            if (count == 0) {
                isEmpty = true;
            } else {
                System.out.println("Current sudoku board after inserting value: \n" + sudokuBoard);
            }
        }
        return sudokuBoard;
    }

    private void removeValueFromPossiblities(SudokuBoard sudokuBoard) throws IndexOutOfBoundsException {
        int row;
        int column;
        int value;
        if (backtrack.size() > 0) {
            int index = backtrack.size() - 1;
            value = backtrack.get(index).getValue();
            row = backtrack.get(index).getRow();
            column = backtrack.get(index).getColumn();
            sudokuBoard.getSudokuRow(row).get(column).getPossibleValues().set(value, SudokuElement.EMPTY);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private SudokuBoard loadLastSavedCopy() throws IndexOutOfBoundsException {

      if (backtrack.size() == 0) {
          System.out.println("Sudoku board is incorrect, please fill it one more time\n");
          System.out.println("Press enter");
          scanner.nextLine();
          restartGame();
          throw new IndexOutOfBoundsException();
      } else {
          int index = backtrack.size() - 1;
          return backtrack.get(index).getSudokuBoard();
      }
    }

    private void deepCopyInGame(SudokuBoard sudokuBoard, int row, int column, int value) {
        SudokuBoardCopy deepCopy = makeDeepCopyOfBoard(sudokuBoard, row, column, value);
        backtrack.add(deepCopy);
    }

    private SudokuBoardCopy makeDeepCopyOfBoard(SudokuBoard sudokuBoard, int row, int column, int value) {
        SudokuBoard deepCopy = sudokuBoard.makeDeepCopyOfBoard(sudokuBoard);
        return new SudokuBoardCopy(deepCopy, row, column, value);
    }



    private void tryInsertValueIntoField(SudokuBoard sudokuBoard, int row, int column) throws SudokuException {

        CheckingSudokuFields checkingSudokuFields = new CheckingSudokuFields(sudokuBoard);
        List<Integer> possibleValues = checkingSudokuFields.checkPossibleValuesInField(sudokuBoard, row, column);
        List<Integer> checkedPossibleValues = checkingSudokuFields.addPossibilitiesToNewList(possibleValues);
        if(checkedPossibleValues.size()==0 && sudokuBoard.getSudokuRow(row).get(column).getValue()==-1) {
            throw new SudokuException();
        } else if(checkedPossibleValues.size()==1) {
            sudokuBoard.getSudokuRow(row).get(column).setValue(checkedPossibleValues.get(0));
        }
    }

    private SudokuBoard fortifyBoardWithFigures () {

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
                        RandomBoard randomBoard = new RandomBoard();
                        int quantity = 20;
                        randomBoard.createRandomBoard(sudokuBoard, quantity);
                        x=howManyElementsInsert;
                        break;
                    case "MEDIUM":
                        sudokuBoard = examplesBoards.getBoardLevelMediumOne();
                        x=howManyElementsInsert;
                        break;
                    case "HARD":
                        sudokuBoard = examplesBoards.getBoardLevelMediumOne();
                        x=howManyElementsInsert;
                        break;
                    case "VERY HARD":
                        sudokuBoard = examplesBoards.getBoardLevelVeryHardOne();
                        x=howManyElementsInsert;
                        break;
                    case "IMPOSSIBLE":
                        sudokuBoard = examplesBoards.getBoardWithoutSolution();
                        x=howManyElementsInsert;
                        break;
                    default:
                        insertOneElement(sudokuBoard);
                        x++;
                        System.out.println("\n Press enter to insert new value into board or SUDOKU to start.\n");
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

    private void sudokuWelcome() {
        System.out.println("Welcome in Sudoku! \n" +
                "Press enter to insert new value into board.\n" +
                "Command RANDOM completes the board with 20 figures and begins the game. \n" +
                "Command MEDIUM returns ready board level medium \n" +
                "Command HARD returns ready board level hard \n" +
                "Command VERY HARD return ready board extra hard \n" +
                "Command IMPOSSIBLE to get board without solution");
    }

    private void insertOneElement(SudokuBoard sudokuBoard) {
        try {
            insertElement(sudokuBoard);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value");
        }
        System.out.println("Current sudoku board: \n" + sudokuBoard);
    }

    private void insertElement(SudokuBoard sudokuBoard) throws NumberFormatException {
        SudokuBoard boardCopy = sudokuBoard.makeDeepCopyOfBoard(sudokuBoard);
        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValuesList = sudokuElement.getPossibleValues();

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
                    deepCopyInGame(boardCopy, row, column, value);
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

