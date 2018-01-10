package com.kodilla.rps.Players;


import com.kodilla.rps.Figures.Figure;
import com.kodilla.rps.Figures.FiguresList;

import java.util.List;
import java.util.Random;


public final class ComputerPlayer {

    public String showFigure() {

        FiguresList figuresList = new FiguresList();
        List<Figure> figuresToDraw = figuresList.getFigures();

        Random random = new Random();

        int i = random.nextInt(3)+1;

        System.out.println("Computer throws: " + figuresToDraw.get(i).getNameOfFigure());

        return figuresToDraw.get(i).getNameOfFigure();

    }


}
