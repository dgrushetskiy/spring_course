package ru.specialist.java.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.specialist.java.spring.annotation.device.cpu.CPU;
import ru.specialist.java.spring.annotation.device.cpu.impl.IntelCPU;
import ru.specialist.java.spring.annotation.device.memory.impl.KingstonMemory;
import ru.specialist.java.spring.annotation.device.memory.impl.SonyMemory;
import ru.specialist.java.spring.annotation.device.memory.Memory;
import ru.specialist.java.spring.annotation.device.screen.Screen;
import ru.specialist.java.spring.annotation.device.screen.impl.ToshibaScreen;
import ru.specialist.java.spring.annotation.device.storage.Storage;
import ru.specialist.java.spring.annotation.device.storage.impl.SonyStorage;
import ru.specialist.java.spring.annotation.device.storage.impl.ToshibaStorage;

import java.util.List;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public CPU cpu() {
        return new IntelCPU();
    }
    @Bean("toshibaScreen")
    public Screen toshibaScreen(){
        return new ToshibaScreen();
    }

    @Bean("listOfMemory")
    public List<Memory> memoryList() {
        return List.of(new KingstonMemory(), new SonyMemory(), new SonyMemory());
    }

    @Bean("storages")
    public List<Storage> storageList() {
        return List.of(new SonyStorage(), new ToshibaStorage());
    }

}
