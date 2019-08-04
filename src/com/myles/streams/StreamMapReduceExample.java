package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Optional;

public class StreamMapReduceExample {

    public static void main(String[] args) {

        Optional<Integer> numberOfNotebooks = numberOfNotebooks();
        numberOfNotebooks.ifPresent(System.out::println);

        Optional<Integer> numberOfNotebooksGrade3 = numberOfNotebooksGrade3OrHigher();
        numberOfNotebooksGrade3.ifPresent(System.out::println);

    }

    static Optional<Integer> numberOfNotebooks() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .map(Student::getNotebooks) // Stream<Integer>
                .reduce(Integer::sum);
    }

    static Optional<Integer> numberOfNotebooksGrade3OrHigher() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGradeLevel() >= 3)
                .map(Student::getNotebooks) // Stream<Integer>
                .reduce(Integer::sum);
    }
}
