package com.example.waa_lab_8_back_end;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WaaLab8BackEnd {

    public static void main(String[] args) {
        SpringApplication.run(WaaLab8BackEnd.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
