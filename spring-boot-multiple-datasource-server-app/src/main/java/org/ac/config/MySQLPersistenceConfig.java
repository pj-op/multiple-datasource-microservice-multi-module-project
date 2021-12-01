package org.ac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:mysql-db.properties"})
@EnableJpaRepositories(basePackages = "org.ac.repositories.mysql", entityManagerFactoryRef = "actorEntityManagerFactory", transactionManagerRef = "actorTransactionManager")
public class MySQLPersistenceConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource actorDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean actorEntityManagerFactory() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform(environment.getProperty("db.database-platform"));

        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setDataSource(actorDataSource());
        entityManagerFactory.setPackagesToScan(new String[]{"org.ac.entities"});
        entityManagerFactory.setPersistenceUnitName("MySQL-Persistence Unit");

        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager actorTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(actorEntityManagerFactory().getObject());
        return transactionManager;
    }


}
