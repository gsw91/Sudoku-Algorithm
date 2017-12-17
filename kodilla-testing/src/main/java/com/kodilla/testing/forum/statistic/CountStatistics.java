<<<<<<< HEAD
package com.kodilla.testing.forum.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountStatistics {

    Statistics statistics;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    List<String> names;
    int posts;
    int comments;

    public List<String> getNames() {
        names = statistics.usersNames();
        return names;
    }

    public int getPosts() {
        posts = statistics.postsCount();
        return posts;
    }

    public int getComments() {
        comments = statistics.commentsCount();
        return comments;
    }

    public List<Double> CalculateAdvStatistics() {
        List<Double> results = new ArrayList<>();
        double actualAveragePostQuantityPerUser = ((double) getPosts() / (double) getNames().size());
        results.add(actualAveragePostQuantityPerUser);
        double actualAverageCommentsQuantityPerUser = (double) getComments() / (double) getNames().size();
        results.add(actualAverageCommentsQuantityPerUser);
        double actualAverageCommentsInOnePost = ((double) getComments() / (double) getPosts());
        results.add(actualAverageCommentsInOnePost);
        return results;
    }

    public HashMap<String, Double> ShowStatistics() {

        HashMap<String, Double> showStatistics = new HashMap<String, Double>();

        showStatistics.put("Names quantity", (double)getNames().size());
        showStatistics.put("Posts quantity", (double)getPosts());
        showStatistics.put("Comments quantity", (double) getComments());
        showStatistics.put("Posts per user", CalculateAdvStatistics().get(0));
        showStatistics.put("Comments per user", CalculateAdvStatistics().get(1));
        showStatistics.put("Comments per post", CalculateAdvStatistics().get(2));

        return showStatistics;
    }
}

=======
package com.kodilla.testing.forum.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountStatistics {

    Statistics statistics;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    List<String> names;
    int posts;
    int comments;

    public List<String> getNames() {
        names = statistics.usersNames();
        return names;
    }

    public int getPosts() {
        posts = statistics.postsCount();
        return posts;
    }

    public int getComments() {
        comments = statistics.commentsCount();
        return comments;
    }

    public List<Double> CalculateAdvStatistics() {
        List<Double> results = new ArrayList<>();
        double actualAveragePostQuantityPerUser = ((double) getPosts() / (double) getNames().size());
        results.add(actualAveragePostQuantityPerUser);
        double actualAverageCommentsQuantityPerUser = (double) getComments() / (double) getNames().size();
        results.add(actualAverageCommentsQuantityPerUser);
        double actualAverageCommentsInOnePost = ((double) getComments() / (double) getPosts());
        results.add(actualAverageCommentsInOnePost);
        return results;
    }

    public HashMap<String, Double> ShowStatistics() {

        HashMap<String, Double> showStatistics = new HashMap<String, Double>();

        showStatistics.put("Names quantity", (double)getNames().size());
        showStatistics.put("Posts quantity", (double)getPosts());
        showStatistics.put("Comments quantity", (double) getComments());
        showStatistics.put("Posts per user", CalculateAdvStatistics().get(0));
        showStatistics.put("Comments per user", CalculateAdvStatistics().get(1));
        showStatistics.put("Comments per post", CalculateAdvStatistics().get(2));

        return showStatistics;
    }
}

>>>>>>> cf5926e39de1ba5604c772c51bd60215968ca514
