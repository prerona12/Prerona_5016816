package com.example.employeemanagementsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSource")
    public DataSource primaryDataSource(DataSourceProperties properties) {
        // Configure the primary data source
    }

    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource(DataSourceProperties properties) {
        // Configure the secondary data source
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            @Qualifier("primaryDataSource") DataSource primaryDataSource) {
        // Set up EntityManagerFactory for primary data source
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        // Set up EntityManagerFactory for secondary data source
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory.getObject());
    }
}
