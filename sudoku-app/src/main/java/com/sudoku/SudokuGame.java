package com.sudoku;


import com.sudoku.SetupGame.GameConfiguration;

public class SudokuGame {

    public static void main(String[] Args) {
        GameConfiguration gameConfiguration = GameConfiguration.getInstance();
        gameConfiguration.run();
    }

}
