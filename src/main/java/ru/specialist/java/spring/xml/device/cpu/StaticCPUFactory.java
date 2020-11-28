package ru.specialist.java.spring.xml.device.cpu;

import ru.specialist.java.spring.xml.device.cpu.impl.AmdCpu;
import ru.specialist.java.spring.xml.device.cpu.impl.IntelCPU;

public class StaticCPUFactory {

    public static CPU createCPU(String name){
        if ("intel".equalsIgnoreCase(name))
            return new IntelCPU();
        else if ("amd".equalsIgnoreCase(name))
            return new AmdCpu();
        return () -> "Default";
    }
}
