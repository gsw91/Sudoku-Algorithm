package com.kodilla.good.patterns.challenges.ex9_1;

public class MovieStoreRunner {

    public static void main (String[] args) {

        MovieStore movieStore = new MovieStore();
        MovieStoreStream movieStoreStream = new MovieStoreStream();
        movieStoreStream.storeStream(movieStore);
    }


}
