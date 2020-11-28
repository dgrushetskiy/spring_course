package ru.specialist.java.spring.xml.device.cpu.impl;

import ru.specialist.java.spring.xml.device.cpu.CPU;

public class AmdCpu implements CPU {

    @Override
    public String getVendor() {
        return "AMD";
    }

}
