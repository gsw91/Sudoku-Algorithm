package com.kodilla.sudoku.SudokuAlgorithms;

import com.kodilla.sudoku.Board.SudokuBoard;
import com.kodilla.sudoku.Board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class ValuesElimination {

    private CheckingSudokuFields checkingSudokuFields;

    public void insertValueByElimination(SudokuBoard sudokuBoard, int row, int column) {
        //insertValueByEliminationInRow(sudokuBoard, row, column);
    }

    public void insertValueByEliminationInRow(SudokuBoard sudokuBoard, int row, int column) {

        SudokuElement sudokuElement = new SudokuElement();
        List<Integer> possibleValues = sudokuElement.getPossibleValues();
        List<Integer> listForLoop;
        List<List<Integer>> otherFieldValues = new ArrayList<>();
        List<Integer> eliminiationList = new ArrayList<>();
        for (int o = 1; o < 10; o++) {
           listForLoop = checkingSudokuFields.checkAllFields(sudokuBoard, row, o, possibleValues);
            if (sudokuBoard.getSudokuRow(row).get(o).getValue() == -1 && column != o) {
                otherFieldValues.add(listForLoop);
                System.out.println("Current possible lists: " + otherFieldValues + ", list added from row: " + row + ", column: " + o);
            }
        }

        List<Integer> possibleValuesInField = checkingSudokuFields.checkAllFields(sudokuBoard, row, column, possibleValues);
        for (int i = 1; i < 10; i++) {
            for (List values : otherFieldValues) {
                if (possibleValuesInField.get(i) != (int) values.get(i)) {
                    eliminiationList.add(possibleValuesInField.get(i));
                    System.out.println("Current size: " + eliminiationList.size() + ", value added: " + possibleValuesInField.get(i));
                } else if (eliminiationList.contains(possibleValuesInField.get(i))) {
                    eliminiationList.remove(possibleValuesInField.get(i));
                    System.out.println("Current size: " + eliminiationList.size() + ", value removed: " + possibleValuesInField.get(i));
                }
            }
        }
    }


    //    List<Integer> eliminationList = new ArrayList<>();

   //     for (int i = 1; i < 10; i++) {
   //         otherFieldValues = sudokuBoard.getSudokuRow(row).get(i).getPossibleValues();
    //        for (int k = 1; k < 10; k++) {
    //            if (possibleValuesInField.get(k).intValue() != otherFieldValues.get(k) && eliminationList.indexOf(possibleValuesInField.get(k)) > 0) {
    //                System.out.println("Rozmiar listy: " + eliminationList.size() + ", dodany element: " + possibleValuesInField.get(k));
    //                eliminationList.add(possibleValuesInField.get(i));
     //           } else {
    //                System.out.println("Error...");
     //           }
    //            if (eliminationList.size() == 1) {
     //               sudokuBoard.getSudokuRow(row).get(column).setValue(eliminationList.get(0));


//            for (int value : otherFieldValues) {
//                if (possibleValuesInField.contains(value) && value > 0 && sudokuBoard.getSudokuRow(row).get(i).getValue() == -1) {
//                    if (eliminationList.contains(value)) {
//
//                        eliminationList.remove(value);
//                        System.out.println("Rozmiar listy: " + eliminationList.size() + ", usunięty element: " + value);
//                    }
//                } else {
//                    eliminationList.add(value);
//                    System.out.println("Rozmiar listy: " + eliminationList.size() + ", dodany element: " + value);

                    //   for (int k = 1; k < 10; k++) {
                    //       int currentValue = sudokuBoard.getSudokuRow(row).get(column).getPossibleValues().get(i)
                    //      int otherValue = sudokuBoard.getSudokuRow(row).get(j).getPossibleValues().get(k);
                    //    if (currentValue != otherValue && otherValue > 0) {
                    //       eliminationList.add(otherValue);
                    //       System.out.println("Dodawanie wartości " + otherValue + ", aktualnie argumentów: " + eliminationList.size());
                    //   } else if (currentValue == otherValue) {
                    //     if (eliminationList.contains(sudokuBoard.getSudokuRow(row).get(i).getPossibleValues().get(j))) {
                    //       eliminationList.remove(sudokuBoard.getSudokuRow(row).get(i).getPossibleValues().get(j));
                    //    }
                    //    System.out.println("Usuwanie wartości " + otherValue + ", aktualnie argumentów: " + eliminationList.size());
                    //  }
        //        }
    //        }


    private void insertValueByEliminationInColumn() {

    }

    private void insertValueByEliminationInSection() {

    }

}
