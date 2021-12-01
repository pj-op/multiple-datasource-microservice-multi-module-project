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

import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:h2-db.properties"})
@EnableJpaRepositories(basePackages = "org.ac.repositories.h2", entityManagerFactoryRef = "cityEntityManagerFactory", transactionManagerRef = "cityTransactionManager")
public class H2PersistenceConfig {
    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public DriverManagerDataSource cityDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.h2.driverClassName"));
        dataSource.setUrl(environment.getProperty("db.h2.url"));
        dataSource.setUsername(environment.getProperty("db.h2.username"));
        dataSource.setPassword(environment.getProperty("db.h2.password"));

        return dataSource;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean cityEntityManagerFactory() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        Properties properties = new Properties();

//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform(environment.getProperty("db.h2.database-platform"));

        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setDataSource(cityDataSource());
        entityManagerFactory.setPackagesToScan(new String[]{"org.ac.entities"});
        entityManagerFactory.setPersistenceUnitName("H2-Persistence Unit");
        entityManagerFactory.setJpaProperties(properties);

        return entityManagerFactory;
    }

    @Bean
    @Primary
    public PlatformTransactionManager cityTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(cityEntityManagerFactory().getObject());
        return transactionManager;
    }


}
