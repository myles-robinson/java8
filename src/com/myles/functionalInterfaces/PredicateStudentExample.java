package com.myles.functionalInterfaces;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> predicate = (student) -> student.getGradeLevel() >= 3;

    static Predicate<Student> predicate2 = (student) -> student.getGpa() >= 3.9;

    private static void filterStudentByGradeLevel() {

        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach(student -> {
            if (predicate.test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByGPA() {

        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach(student -> {
            if (predicate2.test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByGPAandGradeLevel() {

        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach(student -> {
            if (predicate.and(predicate2).test(student)) {
                System.out.println(student);
            }else {
                System.out.println(student.getName() +" does not match these conditions");
            }
        });
    }

    public static void main(String[] args) {

        filterStudentByGradeLevel();
        System.out.println("=========================================");
        filterStudentByGPA();
        System.out.println("=========================================");
        filterStudentByGPAandGradeLevel();
    }
}
