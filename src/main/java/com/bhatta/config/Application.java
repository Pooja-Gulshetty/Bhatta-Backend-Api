package com.bhatta.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bhatta"})
@Configuration
@EntityScan(basePackages = "com.bhatta.domain")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
