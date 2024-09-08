package com.STC.API.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")

public class Contoller {
    @Qualifier("class1")
    private final Interface interface1;
    public Contoller(@Qualifier("dd") Interface interface1) {
        this.interface1 = interface1;
    }
    @GetMapping
    public String helloWorld(){
        return(interface1.helloworld());
    }

}
