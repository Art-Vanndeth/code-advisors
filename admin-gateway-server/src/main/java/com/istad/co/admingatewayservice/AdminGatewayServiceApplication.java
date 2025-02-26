package com.istad.co.admingatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AdminGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminGatewayServiceApplication.class, args);
    }

}
