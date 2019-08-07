package com.myles.optional;

import com.myles.data.Bike;
import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    public static void main(String[] args) {

        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }

    //filter
    static void optionalFilter() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        studentOptional.filter(student -> student.getGpa() >= 3.5)
            .ifPresent(System.out::println);
    }
    //map
    static void optionalMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        if (studentOptional.isPresent()) {
            studentOptional.filter(student -> student.getGpa() >= 3.5)
                    .map(Student::getName) // student -> student.getName()
                    .ifPresent(System.out::println);
        }
    }
    //flatmap
    static void optionalFlatMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        studentOptional
                .filter(student -> student.getGpa() >= 3.5) //Optional<Student <Optional<Bike>>
                .flatMap(Student::getBike) // Optional<Bike>. need to access Optional<Bike> inside Optional<Student>
                .map(Bike::getName)
                .ifPresent(System.out::println);
    }
}
