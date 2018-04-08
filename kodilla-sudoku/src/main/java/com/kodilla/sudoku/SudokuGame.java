package com.kodilla.sudoku;

import com.kodilla.sudoku.SetupGame.GameConfiguration;

public class SudokuGame {

    public static void main(String[] Args) {
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        gameConfiguration.run();
    }

}
