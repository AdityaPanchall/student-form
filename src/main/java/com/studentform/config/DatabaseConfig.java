package com.studentform.config;

public final class DatabaseConfig {

    private DatabaseConfig() {
    }

    public static String getUrl() {

        return getEnvironmentVariable(
                "DB_URL",
                "jdbc:postgresql://localhost:5432/projectForm"
        );
    }

    public static String getUsername() {

        return getEnvironmentVariable(
                "DB_USERNAME",
                "postgres"
        );
    }

    public static String getPassword() {

        return getEnvironmentVariable(
                "DB_PASSWORD",
                "postgres"
        );
    }

    private static String getEnvironmentVariable(
            String name,
            String defaultValue) {

        String value = System.getenv(name);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return value;
    }
}