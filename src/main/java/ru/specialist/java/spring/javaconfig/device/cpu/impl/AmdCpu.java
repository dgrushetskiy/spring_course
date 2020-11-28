package ru.specialist.java.spring.javaconfig.device.cpu.impl;

import ru.specialist.java.spring.javaconfig.device.cpu.CPU;

public class AmdCpu implements CPU {

    @Override
    public String getVendor() {
        return "AMD";
    }

}
