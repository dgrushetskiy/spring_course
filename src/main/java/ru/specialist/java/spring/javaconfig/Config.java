package ru.specialist.java.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.specialist.java.spring.javaconfig.device.cpu.CPU;
import ru.specialist.java.spring.javaconfig.device.cpu.impl.AmdCpu;
import ru.specialist.java.spring.javaconfig.device.cpu.impl.IntelCPU;
import ru.specialist.java.spring.javaconfig.device.memory.Memory;
import ru.specialist.java.spring.javaconfig.device.memory.impl.KingstonMemory;
import ru.specialist.java.spring.javaconfig.device.memory.impl.SonyMemory;

import java.util.List;

@Configuration
public class Config {

    @Bean("myComputer")
    public Computer computer1(){
        Computer c = new Computer();
        c.setCpu(amdCPU());
        c.setMemoryList(memoryList());
        return c;
    }

    @Bean
    public Computer computer(){
        Computer c = new Computer();
        c.setCpu(amdCPU());
        c.setMemoryList(List.of(sonyMemory()));
        return c;
    }

    @Bean
    public CPU intelCPU() {
        return new IntelCPU();
    }

    @Bean
//    @Scope("prototype")
    public CPU amdCPU(){
        return new AmdCpu();
    }

    @Bean
    public Memory sonyMemory(){
        return new SonyMemory();
    }

    @Bean
    public List<Memory> memoryList(){
        return List.of(new KingstonMemory(), new SonyMemory(), new KingstonMemory());
    }
}
