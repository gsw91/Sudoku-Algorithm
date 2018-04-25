package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookA> exampleBooksSet = new HashSet<>();
        BookA example1 = new BookA("Test1", "Testing1", 2010, "test/01");
        BookA example2 = new BookA("Test2", "Testing2", 2009, "test/02");
        BookA example3 = new BookA("Test3", "Testing3", 2008, "test/03");
        BookA example4 = new BookA("Test4", "Testing4", 2011, "test/04");
        BookA example5 = new BookA("Test5", "Testing5", 2012, "test/05");
        exampleBooksSet.add(example1);
        exampleBooksSet.add(example2);
        exampleBooksSet.add(example3);
        exampleBooksSet.add(example4);
        exampleBooksSet.add(example5);
        //When
        int median = medianAdapter.publicationYearMedian(exampleBooksSet);
        //Then
        assertEquals(2010, median);

    }
}
