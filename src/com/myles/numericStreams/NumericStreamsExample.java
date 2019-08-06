package com.myles.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2, 3, 4, 5, 6);

        Optional<Integer> sum = sumOfnNumbers(integerList);
        sum.ifPresent(s -> System.out.println("Sum of n Numbers is : " + sum.get()));

        System.out.println("Sum of n using int Stream: " + sumOfnNumbersIntStream());
    }

    static Optional<Integer> sumOfnNumbers(List<Integer> integerList) {

        return integerList.stream()
                .reduce(Integer::sum);
    }

    static int sumOfnNumbersIntStream() {
        return IntStream.rangeClosed(1, 6) // 1, 2, 3, 4, 5 ,6
            .sum();
    }

}
