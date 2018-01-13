package com.kodilla.rps;


import com.kodilla.rps.Figures.Figure;
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

        gameInformation.showRules();

        gameInformation.infoInsertQuantityOfROunds();

        RoundsLimit roundLimit = new RoundsLimit();
        int gameLimit = roundLimit.getLimit();

        ComputerPlayerProcess computerPlayerProcess = new ComputerPlayerProcess();

        Figure figure = new Figure(null);
        figure.compareScore(humanPlayerProcess, computerPlayerProcess, gameLimit,0,0);

    }


}




