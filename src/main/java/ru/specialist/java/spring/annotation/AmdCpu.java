package ru.specialist.java.spring.annotation;


import org.springframework.stereotype.Component;

@Component
public class AmdCpu implements CPU {

    @Override
    public String getVendor() {
        return "AMD";
    }

}
