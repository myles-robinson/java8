package com.myles.optional;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Optional;

public class OptionalOrElseExample {

    //orElse
    static String optionalOrElse() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
//        studentOptional = Optional.ofNullable(null); // Optional<Empty>

        return studentOptional.map(Student::getName).orElse("Default");
    }
    //orElseGet
    static String optionalOrElseGet() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
//        studentOptional = Optional.ofNullable(null); // Optional<Empty>

        return studentOptional.map(Student::getName).orElseGet(() -> "Default Value");
    }

    //orElseThrow
    static String optionalOrElseThrow() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        studentOptional = Optional.ofNullable(null);

        return studentOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Available"));
    }
    public static void main(String[] args) {

        System.out.println("orElse() : " + optionalOrElse());
        System.out.println("orElseGet() : " + optionalOrElseGet());
        System.out.println("orElseThrow() : " + optionalOrElseThrow());
    }

}
