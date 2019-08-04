package com.myles.streams;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    static List<String> printStudentActivities() {

        return StudentDatabase.getAllStudents().stream() // Stream<Students>
                .map(Student::getActivities)// Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(printStudentActivities());
    }
}
