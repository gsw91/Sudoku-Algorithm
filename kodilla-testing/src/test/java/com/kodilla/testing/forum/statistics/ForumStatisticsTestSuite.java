package com.kodilla.testing.forum.statistics;

import org.junit.Before;
import org.junit.BeforeClass;

import com.kodilla.testing.forum.statistic.CountStatistics;
import com.kodilla.testing.forum.statistic.Statistics;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private static int tryCounter =0;

    @BeforeClass
    public static void textBeforeClass(){
        System.out.println("Testing methods CalculateAdvStatistics() and ShowStatistics()");
    }

    @Before
    public void textBeforeTest(){
        tryCounter++;
        System.out.println("Starting of test number " + tryCounter);
    }

    @After
    public void textAfterTest(){
        System.out.println("The end of test number " + tryCounter);
    }

    //Obliczanie średnich, gdy liczba postów = 0, liczba użytkowników = 5, liczba komentarzy = 10
    @Test
    public void outOfPosts () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 0;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 10;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(2, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(0, countStatistics.getCommentsInOnePost(),0);
    }

    //Obliczanie średnich, gdy liczba postów = 1000, liczba użytkowników = 5, liczba komentarzy = 1000
    @Test
    public void oneThousandPostsAndComments () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 1000;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(200, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(200, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(1, countStatistics.getCommentsInOnePost(),0);
    }

    //Obliczanie średnich, gdy liczba postów = 5, liczba użytkowników = 5, liczba komentarzy = 5
    @Test
    public void allAveragesEqual () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 5;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 5;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(1, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(1, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(1, countStatistics.getCommentsInOnePost(),0);
    }

    //Obliczanie średnich, gdy liczba postów = 100, liczba użytkowników = 5, liczba komentarzy = 0
    @Test
    public void outOfComments () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 100;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 0;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(20, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(0, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(0, countStatistics.getCommentsInOnePost(),0);
    }

    //Obliczanie średnich, gdy liczba postów < liczba komentarzy i liczba użytkowników = 5
    @Test
    public void moreCommentsThanPosts () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 25;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 50;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(5, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(10, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(2, countStatistics.getCommentsInOnePost(),0);
    }
    //Obliczanie średnich, gdy liczba postów > liczba komentarzy i liczba użytkowników = 5
    @Test
    public void morePostsThanComments () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 50;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Adam");
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antoni");
        usersNamesMock.add("Mateusz");
        usersNamesMock.add("Donald");
        int commentsQuantity = 25;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(10, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(5, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(0.5, countStatistics.getCommentsInOnePost(),0);
    }

    //Obliczanie średnich, gdy liczba postów = liczba komentarzy i liczba użytkowników = 0
    @Test
    public void outOfUsers () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 10;
        List<String> usersNamesMock = new ArrayList<>();
        int commentsQuantity = 10;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(0, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(1, countStatistics.getCommentsInOnePost(),0);
    }
    //Obliczanie średnich, gdy liczba postów = liczba komentarzy i liczba użytkowników = 100
    @Test
    public void oneHundredOfUsers () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 10;
        List<String> usersNamesMock = new ArrayList<>();
        for (int i = 0; i <100; i ++){
            usersNamesMock.add("Name" + i);
        }
        int commentsQuantity = 10;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0.1, countStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(0.1, countStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(1, countStatistics.getCommentsInOnePost(),0);
    }

    //Testowanie metody showStatistics()
    @Test
    public void testShowStatistics () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 20;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jaro");
        usersNamesMock.add("Antek");
        usersNamesMock.add("Becia");
        usersNamesMock.add("Mathew");
        int commentsQuantity = 10;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        String statisticsMockTest = countStatistics.ShowStatistics();
        String statisticsValue ="CountStatistics{" +
            "statistics=" + statisticsMock +
                    ", names=" + usersNamesMock +
                    ", posts=" + 20 +
                    ", comments=" + 10 +
                    ", postsQuantityPerUser=" + 5.0 +
                    ", commentsQuantityPerUser=" + 2.5 +
                    ", commentsInOnePost=" + 0.5 +
                    '}';
        //Then
        Assert.assertEquals(statisticsValue, statisticsMockTest);
    }
}