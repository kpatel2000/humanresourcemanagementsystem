package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
