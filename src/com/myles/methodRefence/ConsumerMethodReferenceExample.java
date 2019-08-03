package com.myles.methodRefence;

import com.myles.data.Student;
import com.myles.data.StudentDatabase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Consumer<Student> c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {

        StudentDatabase.getAllStudents().forEach(c1);
        StudentDatabase.getAllStudents().forEach(c2);
        StudentDatabase.getAllStudents().forEach(c3);
    }
}
