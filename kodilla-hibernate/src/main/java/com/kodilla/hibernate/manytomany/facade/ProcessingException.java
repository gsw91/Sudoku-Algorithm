package com.kodilla.hibernate.manytomany.facade;

public class ProcessingException extends Exception {

    public static String ERR_NO_COMPANY = "There is no company of this name in the database";
    public static String ERR_NO_EMPLOYEE = "There is no employee of this lastname in the database";

    public ProcessingException (String message) {
        super(message);
    }

}
