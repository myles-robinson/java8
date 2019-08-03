package com.myles.methodRefence;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    // String and String represent Input and Output
    private static Function<String, String> toUpperCaseLambda = String::toUpperCase;

    // Same as above
    //private static Function<String, String> toUpperCaseLambda = s -> s.toUpperCase();

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("java8"));
    }
}
