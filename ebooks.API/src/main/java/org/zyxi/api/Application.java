package org.zyxi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"org.zyxi"})
@EntityScan(basePackages = "org.zyxi")
@EnableJpaRepositories(basePackages = "org.zyxi")
@SpringBootApplication(scanBasePackages = "org.zyxi")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
