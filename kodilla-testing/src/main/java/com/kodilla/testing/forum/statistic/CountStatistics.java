package com.kodilla.testing.forum.statistic;

import java.util.List;

public class CountStatistics {

    private Statistics statistics;

    public CountStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    private List<String> names;
    private int posts;
    private int comments;
    private double postsQuantityPerUser;
    private double commentsQuantityPerUser;
    private double commentsInOnePost;

    private List<String> getNames() {
        names = statistics.usersNames();
        return names;
    }

    private int getPosts() {
        posts = statistics.postsCount();
        return posts;
    }

    private int getComments() {
        comments = statistics.commentsCount();
        return comments;
    }

    public double getPostsPerUser() {
        return postsQuantityPerUser;
    }

    public double getCommentsPerUser() {
        return commentsQuantityPerUser;
    }

    public double getCommentsInOnePost() {
        return commentsInOnePost;
    }

    public void CalculateAdvStatistics() {

        if(getNames().size()!=0){
            postsQuantityPerUser = ((double) getPosts() / (double) getNames().size());
        } else {
            postsQuantityPerUser = 0;
        }

        if (getNames().size() != 0){
            commentsQuantityPerUser = (double) getComments() / (double) getNames().size();
        } else {
            commentsQuantityPerUser =0;
        }

        if (getPosts() != 0){
            commentsInOnePost = ((double) getComments() / (double) getPosts());
        } else {
            commentsInOnePost = 0;
        }

    }

    @Override
    public String toString() {
        CalculateAdvStatistics();
        return "CountStatistics{" +
                "statistics=" + statistics +
                ", names=" + getNames() +
                ", posts=" + getPosts() +
                ", comments=" + getComments() +
                ", postsQuantityPerUser=" + getPostsPerUser() +
                ", commentsQuantityPerUser=" + getCommentsPerUser() +
                ", commentsInOnePost=" + getCommentsInOnePost() +
                '}';
    }

    public String ShowStatistics() {
        return toString();
    }
}