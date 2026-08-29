package com.studentform.service;

import com.studentform.model.Student;
import com.studentform.repository.StudentRepository;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void validStudentShouldBeAccepted() {

        StudentRepository repository =
                student -> {
                };

        StudentService service =
                new StudentService(repository);

        Student student = new Student(

                "Aditya",

                "Panchal",

                LocalDate.of(
                        2002,
                        5,
                        10
                ),

                "Male",

                "B.Tech",

                2024,

                "9876543210"
        );


        assertDoesNotThrow(
                () ->
                        service.registerStudent(
                                student
                        )
        );
    }


    @Test
    void invalidMobileShouldBeRejected() {

        StudentRepository repository =
                student -> {
                };

        StudentService service =
                new StudentService(repository);

        Student student = new Student(

                "Aditya",

                "Panchal",

                LocalDate.of(
                        2002,
                        5,
                        10
                ),

                "Male",

                "B.Tech",

                2024,

                "123"
        );


        assertThrows(

                IllegalArgumentException.class,

                () ->
                        service.registerStudent(
                                student
                        )
        );
    }


    @Test
    void futureDobShouldBeRejected() {

        StudentRepository repository =
                student -> {
                };

        StudentService service =
                new StudentService(repository);

        Student student = new Student(

                "Aditya",

                "Panchal",

                LocalDate.now().plusDays(1),

                "Male",

                "B.Tech",

                2024,

                "9876543210"
        );


        assertThrows(

                IllegalArgumentException.class,

                () ->
                        service.registerStudent(
                                student
                        )
        );
    }

}