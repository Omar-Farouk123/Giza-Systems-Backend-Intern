package com.STC.API.Demo;

import org.springframework.context.annotation.Primary;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

@Service("dd")
@Primary
public class class1 implements Interface{
    @Override
    public String helloworld() {
        return "hello";
    }
}
