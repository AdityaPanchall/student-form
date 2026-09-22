package com.studentform.repository;

import com.studentform.config.DatabaseConfig;
import com.studentform.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcStudentRepository implements StudentRepository {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static final String CREATE_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS "formDetails" (
                id SERIAL PRIMARY KEY,
                "firstName" VARCHAR(100) NOT NULL,
                "lastName" VARCHAR(100) NOT NULL,
                dob DATE NOT NULL,
                gender VARCHAR(20) NOT NULL,
                highestqualification VARCHAR(100) NOT NULL,
                year_of_passing INTEGER NOT NULL,
                mobilenumber VARCHAR(15) NOT NULL,
                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
            )
            """;

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

        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword())) {

            ensureTableExists(connection);

            try (PreparedStatement statement =
                         connection.prepareStatement(INSERT_SQL)) {

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
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to save student details.",
                    e
            );
        }
    }

    private void ensureTableExists(Connection connection) throws SQLException {
        try (java.sql.Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }
}