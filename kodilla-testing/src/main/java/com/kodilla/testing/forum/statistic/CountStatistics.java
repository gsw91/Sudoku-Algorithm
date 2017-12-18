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
        double actualAveragePostQuantityPerUser;
        if(getNames().size()!=0){
            actualAveragePostQuantityPerUser = ((double) getPosts() / (double) getNames().size());
        } else {
            actualAveragePostQuantityPerUser = 0;
        }
        results.add(actualAveragePostQuantityPerUser);
        double actualAverageCommentsQuantityPerUser;
        if (getNames().size() != 0){
            actualAverageCommentsQuantityPerUser = (double) getComments() / (double) getNames().size();
        } else {
            actualAverageCommentsQuantityPerUser =0;
        }
        results.add(actualAverageCommentsQuantityPerUser);
        double actualAverageCommentsInOnePost;
        if (getPosts() != 0){
            actualAverageCommentsInOnePost = ((double) getComments() / (double) getPosts());
        } else {
            actualAverageCommentsInOnePost = 0;
        }
        results.add(actualAverageCommentsInOnePost);
        return results;
    }

    public List<Double> ShowStatistics() {
        List <Double> results = new ArrayList<>();
        results.add((double)getNames().size());
        results.add((double)getPosts());
        results.add((double)getComments());
        results.add(CalculateAdvStatistics().get(0));
        results.add(CalculateAdvStatistics().get(1));
        results.add(CalculateAdvStatistics().get(2));
        return results;
    }
}