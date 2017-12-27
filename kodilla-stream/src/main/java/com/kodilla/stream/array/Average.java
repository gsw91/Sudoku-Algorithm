package com.kodilla.stream.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

final class Average implements ArrayOperations {

    private final Marks marks;

    public Average(Marks marks) {
        this.marks = marks;
    }

    public Marks getMarks() {
        return marks;
    }

    public double getAverage(int[] numbers){

        ArrayList<Integer> marksTable = IntStream.range(0, numbers.length)
                .map(a -> marks.getMarksTable()[a])
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(marksTable);

        double marksAverage = IntStream.range(0, numbers.length)
                .map(numbers2 -> marks.getMarksTable()[numbers2])
                .average().getAsDouble();
        return marksAverage;
    }





}