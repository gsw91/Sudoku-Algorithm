package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Super świąteczna okazja", " 2 telewizory w cenie 3",((string, string2) -> string + "!!!" + string2.toUpperCase() + "!!!"));
        poemBeautifier.beautify("ktoś widział mikołaja", "nikt nie", (string, string2) -> string2.toUpperCase() + string.replaceAll("ktoś", "").toUpperCase() + "???!!!");
        poemBeautifier.beautify("poszła karolinka", "do gogolina", (string, string2) -> string.replace("a", "A").replace("o","O") + " " + string2.replace("o", "O") );
        poemBeautifier.beautify("java jest trudna", ", powiedziała Zosia.", ((string, string2) -> string.replaceFirst("java", "Java") + string2.replace("g", "G")));
    }
}