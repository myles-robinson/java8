package com.myles.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    private static Predicate<Integer> isEven = (i) -> i % 2 == 0;

    private static Predicate<Integer> divisibleBy5 = (i) -> i % 5 == 0;

    public static void main(String[] args) {

        System.out.println(isEven.test(20));
        System.out.println(isEven.test(55));

        predicateAnd(10);
        predicateAnd(11);

        predicateOr(12);

        predicateNegate(505);
    }

    private static void predicateAnd(int num) {

        // predicate chaining
        System.out.println("Predicate And result is: " + isEven.and(divisibleBy5).test(num));
    }

    private static void predicateOr(int num) {
        System.out.println("Predicate OR result is: " + isEven.or(divisibleBy5).test(num));
    }

    private static void predicateNegate(int num) {
        System.out.println("Predicate Negate result is: " + isEven.or(divisibleBy5).negate().test(num));
    }
}
