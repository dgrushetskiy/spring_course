package ru.specialist.java.spring.xml.device.memory.impl;

import ru.specialist.java.spring.xml.device.memory.Memory;

public class KingstonMemory implements Memory {
    @Override
    public String getVendor() {
        return "Kingston";
    }

}
