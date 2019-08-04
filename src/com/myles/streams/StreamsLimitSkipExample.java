package com.myles.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> sum = getSum(integerList);
        sum.ifPresent(integer -> System.out.println("Sum is : " + integer));

        Optional<Integer> sumWithLimit = limit(integerList);
        sumWithLimit.ifPresent(integer -> System.out.println("Sum with limit is : " + integer));

        Optional<Integer> sumWithSkip = skip(integerList);
        sumWithSkip.ifPresent(integer -> System.out.println("Sum with skip is : " + integer));
    }

    static Optional<Integer> getSum(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer::sum);
    }

    static Optional<Integer> limit(List<Integer> integerList) {
        return integerList.stream()
                .limit(2) // only calculates first 2 elements
                .reduce(Integer::sum);
    }

    static Optional<Integer> skip(List<Integer> integerList) {
        return integerList.stream()
                .skip(3) // will skip first 3 elements
                .reduce(Integer::sum);
    }

}
