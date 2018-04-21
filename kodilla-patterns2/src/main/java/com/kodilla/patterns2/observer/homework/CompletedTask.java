package com.kodilla.patterns2.observer.homework;

public class CompletedTask {
    private final String title;
    private final String link;

    public CompletedTask(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "CompletedTask{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
