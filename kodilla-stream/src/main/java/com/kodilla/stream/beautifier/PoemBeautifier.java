package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify (String string, String string2, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(string, string2);
        System.out.println(result);
        return result;
    }

    public String change (String litera){
        if (litera == "a") {
            return "A";
        }
        if (litera == "o")
            return "O";
        return litera;
    }
}
