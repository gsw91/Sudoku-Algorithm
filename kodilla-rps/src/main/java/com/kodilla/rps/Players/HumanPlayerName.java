package com.kodilla.rps.Players;

import java.util.Scanner;

public class HumanPlayerName {

    public String insertHumanName() {

        String playerName;

        Scanner scanner = new Scanner(System.in);

        playerName = scanner.nextLine();

        return playerName;

    }


}
