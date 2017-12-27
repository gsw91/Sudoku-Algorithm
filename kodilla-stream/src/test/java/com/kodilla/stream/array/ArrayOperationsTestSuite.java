package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int [] marks = new int [20];
        marks[0]=2;
        marks[1]=5;
        marks[2]=3;
        marks[3]=3;
        marks[4]=3;
        marks[5]=4;
        marks[6]=5;
        marks[7]=4;
        marks[8]=3;
        marks[9]=4;
        marks[10]=2;
        marks[11]=2;
        marks[12]=3;
        marks[13]=5;
        marks[14]=6;
        marks[15]=4;
        marks[16]=2;
        marks[17]=4;
        marks[18]=6;
        marks[19]=2;
        Average average = new Average(new Marks(marks));
        //When
        double averageCount = average.getAverage(marks);
        //Then
        Assert.assertEquals(3.6, averageCount,0);
    }
}
