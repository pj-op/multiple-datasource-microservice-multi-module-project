package com.eureka_backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootEurekaBackupApplication.class, args);
    }
}
