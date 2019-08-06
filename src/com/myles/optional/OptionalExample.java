package com.myles.optional;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

//        System.out.println("Student name length : " + getStudentName().length());

        Optional<String> stringOptional = getStudentNameWithOptional();
        stringOptional.ifPresent(s -> System.out.println("Length of Student Name : "
                + s.length()));
    }

    static String getStudentName() {

        Student student = StudentDatabase.studentSupplier.get();

        if (student!= null) {
            return student.getName();
        } else {
            return null;
        }
    }

    static Optional<String> getStudentNameWithOptional() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
//        studentOptional = Optional.ofNullable(null);

        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName); // return Optional<String>
        } else {
            return Optional.empty();
        }
    }
}
