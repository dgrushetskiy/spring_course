package ru.specialist.java.spring.javaconfig.device.memory.impl;

import ru.specialist.java.spring.javaconfig.device.memory.Memory;

public class SonyMemory implements Memory {
    @Override
    public String getVendor() {
        return "Sony";
    }
}
