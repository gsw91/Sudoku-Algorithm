package com.kodilla.rps.GameSystem;

import com.kodilla.rps.Exceptions.RpsException;
import com.kodilla.rps.GameProcess;

public class ConfirmationExitOrReset {

    public void confirmReset(String confirm) throws NumberFormatException {

        if (confirm.equals("y")) {
            System.out.println("Resetting the game... \n");
            GameProcess gameProcess = new GameProcess();
            gameProcess.play();

        } else {
            throw new NumberFormatException();
        }

    }


    public void confirmExit(String confirm) throws NumberFormatException{

        if (confirm.equals("y")) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            throw new NumberFormatException();
        }

    }
}
