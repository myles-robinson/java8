package com.myles.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6, 7, 8, 9,10);
//        List<Integer> integerList = new ArrayList<>();

        int maxValue = findMaxValue(integerList);
        System.out.println("Max value : " + maxValue);

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);

        if (maxValueOptional.isPresent()) {
            System.out.println("Max value with optional : " + maxValueOptional.get());
        } else {
            System.out.println("No max value found");
        }

        Optional<Integer> minValueOptional = findMinValueOptional(integerList);

        if (minValueOptional.isPresent()) {
            System.out.println("Min value with optional : " + minValueOptional.get());
        } else {
            System.out.println("No min value found");
        }
    }

    static int findMaxValue(List<Integer> integerList) {

        return integerList.stream()
                //6
                // 7
                //8
                //9
                //10
                // a holds max value in each iteration starting with 0
                // b has every value from stream
                .reduce(0, (a, b) -> a > b ? a : b);
    }

    static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {

        return integerList.stream()
                //6
                // 7
                //8
                //9
                //10
                // a holds max value in each iteration starting with 0
                // b has every value from stream
                .reduce((a, b) -> a > b ? a : b);
    }

    static Optional<Integer> findMinValueOptional(List<Integer> integerList) {

        return integerList.stream()
                //6
                // 7
                //8
                //9
                //10
                // a holds max value in each iteration starting with 0
                // b has every value from stream
                .reduce((a, b) -> a <= b ? a : b);
    }


}
