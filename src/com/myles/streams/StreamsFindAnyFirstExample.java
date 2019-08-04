package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static void main(String[] args) {

        Optional<Student> studentOptional = findAnyStudent();
        studentOptional.ifPresent(student -> System.out.println("Found " + student));

        Optional<Student> studentFindFirstOptional = findFirstStudent();
        studentFindFirstOptional.ifPresent(student -> System.out.println("Found " + student));
    }

    static Optional<Student> findAnyStudent() {
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    static Optional<Student> findFirstStudent() {
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }
}
