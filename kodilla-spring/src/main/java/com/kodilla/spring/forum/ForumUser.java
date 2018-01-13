package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    String name;

    public ForumUser() {
        this.name = "John Smith";
    }

}
