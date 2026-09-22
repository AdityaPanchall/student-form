package com.studentform.config;

public final class DatabaseConfig {

    private DatabaseConfig() {
    }

    public static String getUrl() {
        return getRequiredEnvironmentVariable("DB_URL");
    }

    public static String getUsername() {
        return getRequiredEnvironmentVariable("DB_USERNAME");
    }

    public static String getPassword() {
        return getRequiredEnvironmentVariable("DB_PASSWORD");
    }

    private static String getRequiredEnvironmentVariable(String name) {

        String value = System.getenv(name);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Required environment variable is not set: " + name
            );
        }

        return value;
    }
}