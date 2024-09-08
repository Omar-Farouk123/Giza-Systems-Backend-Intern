package com.STC.API.Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {


    @Bean
    @Primary
    public Interface anInterface(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();

      return (Interface)  applicationContext.getBean("");
    }



}