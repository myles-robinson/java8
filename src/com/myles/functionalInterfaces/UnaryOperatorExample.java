package com.myles.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    // Type is String and return type is String
    static UnaryOperator<String> unaryOperator = (s -> s.concat("Default"));

    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("java8"));
    }
}
