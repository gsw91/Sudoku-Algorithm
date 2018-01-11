package com.kodilla.rps;


import com.kodilla.rps.GameSystem.*;
import com.kodilla.rps.Players.*;


public class GameProcess {

    public void play() {

        GameInformation gameInformation = new GameInformation();
        gameInformation.showWelcome();

        HumanPlayerName humanPlayerName = new HumanPlayerName();
        String playerName = humanPlayerName.insertHumanName();

        HumanPlayerProcess humanPlayerProcess = new HumanPlayerProcess(playerName);
        System.out.print("Hello " + humanPlayerProcess.getPlayerName());

        ComputerPlayerProcess computerPlayerProcess = new ComputerPlayerProcess();

        gameInformation.showRules();

        gameInformation.infoInsertQuantityOfROunds();

        RoundsLimit roundLimit = new RoundsLimit();

        int limitOfTheGame = roundLimit.getLimit();
        int humanPlayerScore = 0;
        int computerScore = 0;

        GameProcedure gameProcedure = new GameProcedure();
        gameProcedure.runProcedure(humanPlayerProcess, computerPlayerProcess, humanPlayerScore, computerScore, limitOfTheGame);

    }


}




