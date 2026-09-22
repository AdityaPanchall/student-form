package com.studentform.repository;

import com.studentform.config.DatabaseConfig;
import com.studentform.model.Student;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JdbcStudentRepositoryTest {

    @Test
    void saveShouldCreateTableAndPersistStudentWhenTableIsMissing() throws Exception {
        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement dropStatement = connection.createStatement()) {

            dropStatement.execute("DROP TABLE IF EXISTS \"formDetails\"");
        }

        JdbcStudentRepository repository = new JdbcStudentRepository();
        Student student = new Student(
                "Alice",
                "Johnson",
                LocalDate.of(2000, 5, 15),
                "Female",
                "B.Tech",
                2024,
                "9876543210"
        );

        assertDoesNotThrow(() -> repository.save(student));

        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT COUNT(*) FROM \"formDetails\""
             );
             ResultSet resultSet = statement.executeQuery()) {

            resultSet.next();
            assertEquals(1, resultSet.getInt(1));
        }
    }
}
