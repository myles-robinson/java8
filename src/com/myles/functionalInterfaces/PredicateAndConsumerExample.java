package com.myles.functionalInterfaces;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    private Predicate<Student> studentPredicate = (student) -> student.getGradeLevel() >= 3;
    private Predicate<Student> studentPredicate2 = (student) -> student.getGpa() >= 3.9;

    private BiPredicate<Integer, Double> studentBiPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    private BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> {
        System.out.println(name + ": " + activities);
    };

    private Consumer<Student> studentConsumerWithBiPredicate = (student -> {
        if (studentBiPredicate.test(student.getGradeLevel(), student.getGpa())) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    private Consumer<Student> studentConsumer = (student -> {
        if (studentPredicate.and(studentPredicate2).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }

    private void printNameAndActivities(List<Student> studentList) {
        studentList.forEach(studentConsumerWithBiPredicate);
    }
}
