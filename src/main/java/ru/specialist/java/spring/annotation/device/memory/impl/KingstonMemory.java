package ru.specialist.java.spring.annotation.device.memory.impl;


import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.memory.Memory;

@Component
public class KingstonMemory implements Memory {
    @Override
    public String getVendor() {
        return "Kingston";
    }

}
