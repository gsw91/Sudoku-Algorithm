package com.kodilla.testing.forum.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountStatistics {

    Statistics statistics;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<Double> CalculateAdvStatistics() {
        List<Double> results = new ArrayList<>();
        double actualAveragePostQuantityPerUser = ((double) statistics.postsCount() / (double) statistics.usersNames().size());
        results.add(actualAveragePostQuantityPerUser);
        double actualAverageCommentsQuantityPerUser = (double) statistics.commentsCount() / (double) statistics.usersNames().size();
        results.add(actualAverageCommentsQuantityPerUser);
        double actualAverageCommentsInOnePost = ((double) statistics.commentsCount() / (double) statistics.postsCount());
        results.add(actualAverageCommentsInOnePost);
        return results;
    }

    public HashMap<String, Double> ShowStatistics() {

        HashMap<String, Double> showStatistics = new HashMap<String, Double>();

        double returnUserNames = (double)statistics.usersNames().size();
        showStatistics.put("Names quantity", returnUserNames);
        double returnPosts = (double)statistics.postsCount();
        showStatistics.put("Posts quantity", returnPosts);
        double returnComments = (double)statistics.commentsCount();
        showStatistics.put("Comments quantity", returnComments);
        double actualAveragePostQuantityPerUser = (double)statistics.postsCount() / (double)statistics.usersNames().size();
        showStatistics.put("Posts per user", actualAveragePostQuantityPerUser);
        double actualAverageCommentsQuantityPerUser = (double)statistics.commentsCount() / (double)statistics.usersNames().size();
        showStatistics.put("Comments per user", actualAverageCommentsQuantityPerUser);
        double actualAverageCommentsInOnePost = (double)statistics.commentsCount() / (double)statistics.postsCount();
        showStatistics.put("Comments per post", actualAverageCommentsInOnePost);

        System.out.println(showStatistics);

        return showStatistics;
    }
}

