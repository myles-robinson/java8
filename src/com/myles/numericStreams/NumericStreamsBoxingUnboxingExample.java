package com.myles.numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

    public static void main(String[] args) {
        System.out.println("Boxing : " + boxing());
    }

    static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10) // int stream of 10 elements
                // int
                .boxed()
                .collect(Collectors.toList()); // converts to Integer
    }

}
