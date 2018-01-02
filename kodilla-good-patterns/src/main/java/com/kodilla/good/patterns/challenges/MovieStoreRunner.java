package com.kodilla.good.patterns.challenges;

public class MovieStoreRunner {

    public static void main (String[] args) {

        MovieStore movieStore = new MovieStore();
        MovieStoreStream movieStoreStream = new MovieStoreStream();
        movieStoreStream.storeStream(movieStore);
    }


}
