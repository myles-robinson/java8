package com.myles.numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    public static void main(String[] args) {

        System.out.println("mapToObj : " + mapToObj());
        System.out.println("mapToLong : " + mapToLong());
        System.out.println("mapToDouble : " + mapToDouble());
    }

    static List<Integer> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    static Long mapToLong() {

        return IntStream.rangeClosed(1, 5)
                .mapToLong(x -> x)
                .sum();
    }

    static Double mapToDouble() {

        return IntStream.rangeClosed(1, 5)
                .mapToDouble(x -> x)
                .sum();
    }



}
