package ru.specialist.java.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.specialist.java.spring.javaconfig.device.cpu.CPU;
import ru.specialist.java.spring.javaconfig.device.cpu.impl.AmdCpu;
import ru.specialist.java.spring.javaconfig.device.cpu.impl.IntelCPU;
import ru.specialist.java.spring.javaconfig.device.memory.Memory;
import ru.specialist.java.spring.javaconfig.device.memory.impl.KingstonMemory;
import ru.specialist.java.spring.javaconfig.device.memory.impl.SonyMemory;
import ru.specialist.java.spring.javaconfig.device.screen.Screen;
import ru.specialist.java.spring.javaconfig.device.screen.impl.ToshibaScreen;
import ru.specialist.java.spring.javaconfig.device.storage.Storage;
import ru.specialist.java.spring.javaconfig.device.storage.impl.SonyStorage;
import ru.specialist.java.spring.javaconfig.device.storage.impl.ToshibaStorage;

import java.util.List;

@Configuration
public class Config {

    @Bean("myComputer")
    public Computer myComputer(){
        Computer c = new Computer();
        c.setCpu(amdCPU());
        c.setScreen(toshibaScreen());
        c.setMemoryList(memoryList());
        c.setStorageList(storageList());
        return c;
    }

    @Bean
    public Computer computer(){
        Computer c = new Computer();
        c.setCpu(amdCPU());
        c.setScreen(toshibaScreen());
        c.setMemoryList(List.of(sonyMemory()));
        c.setStorageList(storageList());
        return c;
    }

    @Bean
    public CPU intelCPU() {
        return new IntelCPU();
    }

    @Bean
    public Screen toshibaScreen(){
        return new ToshibaScreen();
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

    @Bean
    public List<Storage> storageList(){
        return List.of(new ToshibaStorage(), new SonyStorage());
    }
}
