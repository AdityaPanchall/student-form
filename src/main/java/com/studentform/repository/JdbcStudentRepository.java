package com.studentform.repository;

import com.studentform.config.DatabaseConfig;
import com.studentform.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcStudentRepository implements StudentRepository {

    private static final String INSERT_SQL = """
            INSERT INTO "formDetails"
            (
                "firstName",
                "lastName",
                dob,
                gender,
                highestqualification,
                year_of_passing,
                mobilenumber
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    @Override
    public void save(Student student) {

        try (
                Connection connection =
                        DriverManager.getConnection(
                                DatabaseConfig.getUrl(),
                                DatabaseConfig.getUsername(),
                                DatabaseConfig.getPassword()
                        );

                PreparedStatement statement =
                        connection.prepareStatement(INSERT_SQL)
        ) {

            statement.setString(
                    1,
                    student.getFirstName()
            );

            statement.setString(
                    2,
                    student.getLastName()
            );

            statement.setDate(
                    3,
                    java.sql.Date.valueOf(
                            student.getDob()
                    )
            );

            statement.setString(
                    4,
                    student.getGender()
            );

            statement.setString(
                    5,
                    student.getHighestQualification()
            );

            statement.setInt(
                    6,
                    student.getYearOfPassing()
            );

            statement.setString(
                    7,
                    student.getMobileNumber()
            );

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to save student details.",
                    e
            );
        }
    }
}