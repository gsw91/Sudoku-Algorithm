package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library");
        library.books.add(new Book("Ozon atakuje", "Mark Twain", LocalDate.of(2018, 01, 25)));
        library.books.add(new Book("Soyer na końcu świata", "Mark Twain", LocalDate.of(2018,01,24)));
        library.books.add(new Book("Nowy rozdział","G. Lucas", LocalDate.of(2018,01,23)));
        //When
        //Then
        Assert.assertEquals(3, library.books.size());

        //Shallow copy test
        //When
        Library shallowlyCopiedLibrary = null;
        try {
            shallowlyCopiedLibrary = library.shallowCopy();
            shallowlyCopiedLibrary.setName("Shallow copy of library");
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception: " + e);
        }
        //Then
        Assert.assertEquals(3, shallowlyCopiedLibrary.books.size());

        //Deep copy test
        //When
        Library deeplyCopiedLibrary = null;
        try {
            deeplyCopiedLibrary = library.deepCopy();
            deeplyCopiedLibrary.setName("Deep copy of library");
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception: " + e);
        }
        //Then
        Assert.assertEquals(3, deeplyCopiedLibrary.books.size());

        //Results after removing all book
        //When
        library.getBooks().clear();
        //Then
        Assert.assertEquals(0, library.getBooks().size());
        Assert.assertEquals(0, shallowlyCopiedLibrary.getBooks().size());
        Assert.assertEquals(3,deeplyCopiedLibrary.getBooks().size());
    }

}
