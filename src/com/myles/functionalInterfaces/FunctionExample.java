package com.myles.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    private static Function<String, String> function = (name) -> name.toUpperCase();

    static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("default");

    public static void main(String[] args) {
        System.out.println("Result is: " + function.apply("java8"));

        // operates in order
        System.out.println("Result of andThen is :" + function.andThen(addSomeString).apply("java8"));

        // compose happens first
        System.out.println("Result of andThen is :" + function.compose(addSomeString).apply("java8"));
    }
}
