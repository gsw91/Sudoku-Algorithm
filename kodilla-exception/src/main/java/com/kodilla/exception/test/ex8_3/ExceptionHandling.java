package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public static void main (String[] args){
        SecondChallenge challenge = new SecondChallenge();

        try {
            challenge.probablyIWillThrowException(11,2.3);
        } catch (Exception e) {
            System.out.println("Ops... something gone wrong! Error: " + e);
        } finally {
            System.out.println("Done!");
        }
    }

}
