package com.example.datamigration.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.datamigration.repo.newDb",
        entityManagerFactoryRef = "newDbEntityManager",
        transactionManagerRef = "newDbTransactionManager")
public class NewDbConfig {

    @Primary
    @Bean(name = "newDbDataSource")
    @ConfigurationProperties("spring.datasource.new")
    public DataSource dataSource() {


        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "newDbEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("newDbDataSource") DataSource dataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return builder
                .dataSource(dataSource)
                .packages("com.example.datamigration.entity")
                .persistenceUnit("new")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean("newDbTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("newDbEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}