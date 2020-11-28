package ru.specialist.java.spring.annotation.device.cpu.impl;


import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.cpu.CPU;

@Component
public class AmdCpu implements CPU {

    @Override
    public String getVendor() {
        return "AMD";
    }

}
