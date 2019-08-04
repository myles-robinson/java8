package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        // student name and activities in a map

        Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGPAPredicate = student -> student.getGpa() >= 3.9;
        Consumer<Student> studentConsumer = System.out::println;

        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream()
                .filter(studentPredicate)
                .peek(studentConsumer)
                .filter(studentGPAPredicate)
                .peek(student -> System.out.println("After first filter: " + student))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(studentMap);
    }
}
