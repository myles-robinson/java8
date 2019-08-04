package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 3, 5, 7);

        System.out.println(performMultiplication(integers));

        Optional<Student> studentOptional = getHighestGPAStudent();
        if (studentOptional.isPresent()) System.out.println(studentOptional);
    }

    public static int performMultiplication(List<Integer> list) {

        return list.stream()
                //1
                //3
                //5
                //7
                // a=1, b=1 (from stream) => 1 * 1
                // a=1 (previous result), b=3 (from stream) => 3
                // a=3 (previous result), b=5 (from stream) => 15
                .reduce(1, (a,b) -> a*b);
    }

    public static Optional<Student> getHighestGPAStudent() {

        return StudentDatabase.getAllStudents().stream()
                // get students one by one and returns highest gpa student
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }

}
