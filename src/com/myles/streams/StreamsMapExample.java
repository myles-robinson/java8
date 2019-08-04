package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsMapExample {

    static List<String> namesList() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // student as input -> Student name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<Stream> -> uppercase Operation on each input
                .collect(toList());
    }

    static Set<String> namesSet() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // student as input -> Student name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<Stream> -> uppercase Operation on each input
                .collect(toSet());
    }

    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
