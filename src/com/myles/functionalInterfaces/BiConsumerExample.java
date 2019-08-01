package com.myles.functionalInterfaces;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        };

        biConsumer.accept("Java 7", "Java 8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplication is : " + a*b);
        };

        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("Division is : " + a/b);
        };

        multiply.andThen(division).accept(10, 5);

        nameAndActivities();
    }

    private static void nameAndActivities () {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
            System.out.println("Name: " + name);
            System.out.println("Activities: " + activities);
        };
        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }
}
