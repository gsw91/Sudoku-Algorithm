package com.kodilla.good.patterns.challenges.ex9_1;

import java.util.stream.Collectors;

public class MovieStoreStream {

    public void storeStream (MovieStore movieStore) {

        String store = movieStore.getMovies().entrySet().stream()
                .flatMap(i -> i.getValue().stream())
                .map(n -> n.replaceAll(n, n+"!"))
                .collect(Collectors.joining());

        System.out.println(store);
    }


}
