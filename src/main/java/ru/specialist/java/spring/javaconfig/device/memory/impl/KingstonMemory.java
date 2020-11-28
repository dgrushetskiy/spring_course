package ru.specialist.java.spring.javaconfig.device.memory.impl;

import ru.specialist.java.spring.javaconfig.device.memory.Memory;

public class KingstonMemory implements Memory {
    @Override
    public String getVendor() {
        return "Kingston";
    }

}
