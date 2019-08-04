package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        // student name and activities in a map

        Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGPAPredicate = student -> student.getGpa() >= 3.9;

        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream()
                .filter(studentPredicate)
                .filter(studentGPAPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(studentMap);
    }
}
