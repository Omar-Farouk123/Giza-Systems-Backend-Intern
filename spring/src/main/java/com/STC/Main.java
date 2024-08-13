package com.STC;

import com.STC.Employee.EmployeeServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeServices myService) {
        return args -> {
            myService.populateEmployee();
        };
    }
}
