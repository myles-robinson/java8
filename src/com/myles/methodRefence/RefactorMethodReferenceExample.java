package com.myles.methodRefence;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> predicate = RefactorMethodReferenceExample::greaterThanGradeLevel;

    // refactored to create method reference
    public static boolean greaterThanGradeLevel(Student student) {
        return student.getGradeLevel() >= 3;
    }

    public static void main(String[] args) {

        System.out.println(predicate.test(StudentDatabase.studentSupplier.get()));

    }
}
