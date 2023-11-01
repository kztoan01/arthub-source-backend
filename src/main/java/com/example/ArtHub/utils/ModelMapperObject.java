package com.example.ArtHub.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperObject {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
