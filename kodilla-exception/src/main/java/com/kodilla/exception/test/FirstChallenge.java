package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        double c;
            try {
                if (b==0) {
                    throw new ArithmeticException();
                } else {
                    c = a/b;
                }
                return c;
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e);
            } finally {
                System.out.println("Keep going! Never give up!");
            }
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);
    }
}