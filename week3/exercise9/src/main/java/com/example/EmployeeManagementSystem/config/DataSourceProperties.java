package com.example.employeemanagementsystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String databasePlatform;

    // Getters and Setters
}
