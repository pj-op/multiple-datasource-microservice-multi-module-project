package org.ac;

import org.ac.repositories.h2.ProductRepository;
import org.ac.repositories.mongo.CustomerRepository;
import org.ac.repositories.mysql.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//@EnableEurekaClient                           // Specifically for Eureka server
@EnableDiscoveryClient                          // Can be used for any kind of service discovery registry
@SpringBootApplication
public class TestApplication {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CustomerRepository customerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main method");
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
//            System.out.println(productRepository.findAll());
//            System.out.println(userRepository.findAll());
//            System.out.println(customerRepository.findAll());
        };
    }

}
