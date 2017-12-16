package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistic.CountStatistics;
import com.kodilla.testing.forum.statistic.Statistics;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    //Metoda CalculateAdvStatistics zwraca:
    // get(0) - double actualAveragePostQuantityPerUser
    // get(1) - double actualAverageCommentsQuantityPerUser
    // get(2) - double actualAverageCommentsInOnePost

    private static int tryCounter =0;

    @BeforeClass
    public static void textBeforeClass(){
        System.out.println("Testing of method calculateAdvStatistics");
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0, averages.get(0), 0);
        Assert.assertEquals(2, averages.get(1), 0);
        Assert.assertEquals(0, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(200, averages.get(0), 0);
        Assert.assertEquals(200, averages.get(1), 0);
        Assert.assertEquals(1, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(1, averages.get(0), 0);
        Assert.assertEquals(1, averages.get(1), 0);
        Assert.assertEquals(1, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(20, averages.get(0), 0);
        Assert.assertEquals(0, averages.get(1), 0);
        Assert.assertEquals(0, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(5, averages.get(0), 0);
        Assert.assertEquals(10, averages.get(1), 0);
        Assert.assertEquals(2, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(10, averages.get(0), 0);
        Assert.assertEquals(5, averages.get(1), 0);
        Assert.assertEquals(0.5, averages.get(2),0);
    }

    //Obliczanie średnich, gdy liczba postów = liczba komentarzy i liczba użytkowników = 0
    @Test
    public void outOfUsers () {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postsQuantity = 10;
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.isEmpty();
        int commentsQuantity = 10;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);
        when(statisticsMock.usersNames()).thenReturn(usersNamesMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
        CountStatistics countStatistics = new CountStatistics(statisticsMock);
        //When
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0, averages.get(0), 0);
        Assert.assertEquals(0, averages.get(1), 0);
        Assert.assertEquals(1, averages.get(2),0);
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
        List<Double> averages = countStatistics.CalculateAdvStatistics();
        //Then
        Assert.assertEquals(0.1, averages.get(0), 0);
        Assert.assertEquals(0.1, averages.get(1), 0);
        Assert.assertEquals(1, averages.get(2),0);
    }

    //Testowanie metody showStatistics()
    //get(0) - returnUserNames
    //get(1) - returnPosts
    //get(2) - returnComments
    //get(3) - actualAveragePostQuantityPerUser
    //get(4) - actualAverageCommentsQuantityPerUser
    //get(5) - actualAverageCommentsInOnePost
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
        HashMap<String, Double> showStatisticsTest = new HashMap<String, Double>();
        showStatisticsTest.put("Names quantity", 4.00);
        showStatisticsTest.put("Posts quantity", 20.00);
        showStatisticsTest.put("Comments quantity", 10.00);
        showStatisticsTest.put("Posts per user", 5.00);
        showStatisticsTest.put("Comments per user", 2.50);
        showStatisticsTest.put("Comments per post", 0.50);

        HashMap<String, Double> mockStatisticsList = countStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(showStatisticsTest, mockStatisticsList);

    }

}