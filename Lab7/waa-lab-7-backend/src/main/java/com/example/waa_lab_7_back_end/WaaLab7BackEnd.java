package com.example.waa_lab_7_back_end;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WaaLab7BackEnd {

    public static void main(String[] args) {
        SpringApplication.run(WaaLab7BackEnd.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
