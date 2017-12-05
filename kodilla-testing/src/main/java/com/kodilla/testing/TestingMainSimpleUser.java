package com.kodilla.testing;

import  com.kodilla.testing.user.SimpleUser;

public class TestingMainSimpleUser {
    public static void main(String[] args) {

        SimpleUser newUser = new SimpleUser("theForumUser");
        String result = newUser.getUserName();
        if (result.equals("theForumUser")) {
            System.out.println("Test ok!");
        } else {
            System.out.println("Error");
        }
    }
}