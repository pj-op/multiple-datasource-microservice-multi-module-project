package com.apig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAPIGatewayApplication {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("multipleDataSource", r -> r.path("/api/**")
//                        .and()
//                        .query("platform", "mobile")
                        .uri("lb://MULTIPLE-DATASOURCE"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAPIGatewayApplication.class, args);
    }
}
