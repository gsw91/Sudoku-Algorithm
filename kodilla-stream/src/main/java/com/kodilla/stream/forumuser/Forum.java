package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(0001,"Zygzag11", 'M',LocalDate.of(1991, Month.APRIL, 21), 10));
        forumUserList.add(new ForumUser(0002, "Danny2391", 'M',LocalDate.of(1999, Month.JANUARY, 21),10));
        forumUserList.add(new ForumUser(0003,"susana221",'F',LocalDate.of(1980, Month.NOVEMBER, 02),32));
        forumUserList.add(new ForumUser(0004,"kata1",'F',LocalDate.of(1998,Month.MARCH, 04),55));
        forumUserList.add(new ForumUser(0005,"luzakkk", 'M', LocalDate.of(1977, Month.MAY, 22), 19));
        forumUserList.add(new ForumUser(0006,"New User",'D', LocalDate.of(2000, Month.JULY, 20),0));
    }

    public List<ForumUser> getUserList(){
        return forumUserList;
    }
}
