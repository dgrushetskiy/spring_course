package ru.specialist.java.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class Config {


    @Bean("listOfMemory")
    public List<Memory> memoryList(){
        return List.of(new KingstonMemory(), new SonyMemory(), new SonyMemory());
    }

}
