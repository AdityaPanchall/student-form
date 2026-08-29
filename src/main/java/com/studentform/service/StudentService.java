package com.studentform.service;

import com.studentform.model.Student;
import com.studentform.repository.StudentRepository;

import java.time.LocalDate;
import java.time.Year;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void registerStudent(Student student) {

        validate(student);

        repository.save(student);
    }

    private void validate(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student details are required."
            );
        }

        if (isBlank(student.getFirstName())) {
            throw new IllegalArgumentException(
                    "First name is required."
            );
        }

        if (isBlank(student.getLastName())) {
            throw new IllegalArgumentException(
                    "Last name is required."
            );
        }

        if (student.getDob() == null) {
            throw new IllegalArgumentException(
                    "Date of birth is required."
            );
        }

        if (!student.getDob().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Date of birth must be in the past."
            );
        }

        if (isBlank(student.getGender())) {
            throw new IllegalArgumentException(
                    "Gender is required."
            );
        }

        if (isBlank(student.getHighestQualification())) {
            throw new IllegalArgumentException(
                    "Highest qualification is required."
            );
        }

        int currentYear = Year.now().getValue();

        if (
                student.getYearOfPassing() < 1950 ||
                student.getYearOfPassing() > currentYear
        ) {

            throw new IllegalArgumentException(
                    "Invalid year of passing."
            );
        }

        if (
                student.getMobileNumber() == null ||
                !student.getMobileNumber()
                        .matches("\\d{10,15}")
        ) {

            throw new IllegalArgumentException(
                    "Mobile number must contain 10-15 digits."
            );
        }
    }

    private boolean isBlank(String value) {

        return value == null ||
                value.trim().isEmpty();
    }
}