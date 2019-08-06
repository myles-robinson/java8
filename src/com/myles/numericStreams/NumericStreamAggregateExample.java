package com.myles.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 50)
        .sum();

        OptionalInt optionalInt= IntStream.rangeClosed(1, 50).max();

        System.out.println(optionalInt.isPresent() ? optionalInt.getAsInt() : 0);
        System.out.println("Sum is : " + sum);

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 50).average();
        System.out.println(optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0);
    }

}
