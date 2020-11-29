package ru.specialist.java.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.cpu.CPU;
import ru.specialist.java.spring.annotation.device.memory.Memory;
import ru.specialist.java.spring.annotation.device.screen.Screen;
import ru.specialist.java.spring.annotation.device.storage.Storage;

import java.util.List;

@Component
public class Computer {


    //    @Autowired
//    @Qualifier("myCpu")
    private CPU cpu;

    private Screen screen;


    //    @Autowired
    private List<Memory> memoryList;

    private List<Storage> storageList;


    public Computer() {

    }

    //    @Autowired
    public Computer(CPU cpu) {
        this.cpu = cpu;
    }


    public Computer(CPU cpu, @Qualifier("listOfMemory") List<Memory> memoryList) {
        this.cpu = cpu;
        this.memoryList = memoryList;
    }

    @Autowired
    public Computer(CPU cpu,  Screen screen, @Qualifier("listOfMemory") List<Memory> memoryList, @Qualifier("storages") List<Storage> storageList) {
        this.cpu = cpu;
        this.screen = screen;
        this.memoryList = memoryList;
        this.storageList = storageList;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    //    @Autowired
    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }


    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }
}
