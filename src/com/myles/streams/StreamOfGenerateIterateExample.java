package com.myles.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Adam", "Dan", "Julie");
        stringStream.forEach(System.out::println);

        Stream.iterate(1, x -> x *2) // creates infinite stream
                .limit(15)
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Supplier<Integer> random = new Random()::nextInt;
        Stream.generate(integerSupplier) // creates infinite stream
                .limit(15)
                .forEach(System.out::println);
    }

}
