package com.kodilla.rps;

import com.kodilla.rps.Players.HumanPlayer;
import com.kodilla.rps.Players.HumanPlayerName;
import com.kodilla.rps.Players.Player;

public class ScoreComparision {

    public void showScore(){

        HumanPlayerName humanPlayerName = new HumanPlayerName();

        HumanPlayer humanPlayer = new HumanPlayer(humanPlayerName.insertHumanName());

        System.out.println("Score of " +humanPlayer.getPlayerName() +": " );
        System.out.println("Score of computer player: " );


    }
}
