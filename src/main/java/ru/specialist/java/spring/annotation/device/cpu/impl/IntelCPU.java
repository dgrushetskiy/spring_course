package ru.specialist.java.spring.annotation.device.cpu.impl;

import ru.specialist.java.spring.annotation.device.cpu.CPU;

//@Component("myCpu")
public class IntelCPU implements CPU {
    @Override
    public String getVendor() {
        return "Intel";
    }
}
