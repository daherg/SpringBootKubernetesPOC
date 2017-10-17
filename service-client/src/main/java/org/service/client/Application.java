package org.service.client;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@Api(value = "service-client", description = "All operations for the service-client.")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}