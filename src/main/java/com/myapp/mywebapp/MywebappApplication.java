package com.myapp.mywebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MywebappApplication {

    public static void main(String[] args) {

        SpringApplication.run(MywebappApplication.class, args);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawpass = "12345678";
        String encodepass= encoder.encode(rawpass);

    }

}
