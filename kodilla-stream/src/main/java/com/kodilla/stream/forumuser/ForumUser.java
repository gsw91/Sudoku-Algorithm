package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth ;
    private final int postsPublished;

    public ForumUser(final int userID, final String username, final char sex, final LocalDate dateOfBirth, final int postsPublished) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsPublished = postsPublished;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        if(sex =='M'){
            return sex;
        } else if ( sex =='F'){
            return sex;
        } else {
            return ' ';
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsPublished() {
        return postsPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirrth=" + dateOfBirth +
                ", postsPublished=" + postsPublished +
                '}';
    }
}
