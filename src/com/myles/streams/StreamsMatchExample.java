package com.myles.streams;

import com.myles.data.StudentDatabase;

public class StreamsMatchExample {

    public static void main(String[] args) {
        System.out.println("Result of all match : " + allMatch());
        System.out.println("Result of any match : " + anyMatch());
        System.out.println("Result of none match : " + noneMatch());
    }

    public static boolean allMatch() {
        return StudentDatabase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.9);
    }

    public static boolean anyMatch() {
        return StudentDatabase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() >= 4.0);
    }

    public static boolean noneMatch() {
        return StudentDatabase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() >= 4.1);
    }

}
