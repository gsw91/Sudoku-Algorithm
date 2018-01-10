package com.kodilla.rps.Figures;


import java.util.ArrayList;
import java.util.List;


public class FiguresList {

    public List getFigures(){

        List<Figure> figuresList = new ArrayList<>();
        figuresList.add(0, null);
        figuresList.add(1, new Paper("Paper"));
        figuresList.add(2, new Rock("Rock"));
        figuresList.add(3, new Scissors("Scissors"));

        return figuresList;

    }


}
