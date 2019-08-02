package com.myles.functionalInterfaces;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> {
            return new Student("Dave",3,4.0,"male", Arrays.asList("swimming", "gymnastics","soccer"));
        };

        // returns new student without any input
        System.out.println("Student is : " + studentSupplier.get());

        Supplier<List<Student>> listSupplier = () -> StudentDatabase.getAllStudents();

        System.out.println("Students are : " + listSupplier.get());
    }
}
