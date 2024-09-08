package com.STC.API.Demo;

import org.springframework.stereotype.Service;

@Service
public class class2 implements Interface{
    @Override
    public String helloworld() {
        return "world";
    }
}
