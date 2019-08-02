package com.myles.functionalInterfaces;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    private static Consumer<Student> consumer2 = (student) -> System.out.println(student);
    private static Consumer<Student> consumer3 = (student) -> System.out.print(student.getName());
    private static Consumer<Student> consumer4 = (student) -> System.out.println(student.getActivities());


    public static void main(String[] args) {

        Consumer<String> c1 = (s -> System.out.println(s.toUpperCase()));

        c1.accept("java8");

        lowercase("HELLO WORLD");
        lowercase("GOODBYE WORLD");

        printName();
        System.out.println("=================================================");
        printNameAndActivities();
        System.out.println("=================================================");
        printNameAndActivitiesUsingCondition();
    }

    private static void lowercase(String word) {
        Consumer<String> temp = (w) -> System.out.println(w.toLowerCase());
        temp.accept(word);
    }

    private static void printName() {
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(consumer2);
    }

    private static void printNameAndActivities() {


        List<Student> studentList = StudentDatabase.getAllStudents();

        // consumer chaining
        studentList.forEach(consumer3.andThen(consumer4));
    }

    private static void printNameAndActivitiesUsingCondition() {
        List<Student> studentList = StudentDatabase.getAllStudents();

        // consumer chaining
        studentList.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                consumer3.andThen(consumer4).accept(student);
            }
        });
    }

}
