package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static void main(String[] args) {

        System.out.println("Students sorted by name:");
        sortStudentsByName().forEach(System.out::println);
        System.out.println("Students sorted by GPA:");
        sortStudentsByGPA().forEach(System.out::println);
    }

    public static List<Student> sortStudentsByName() {

        return StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPA() {

        return StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
}
