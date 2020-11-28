package ru.specialist.java.spring.xml;

import ru.specialist.java.spring.xml.device.cpu.CPU;
import ru.specialist.java.spring.xml.device.memory.Memory;
import ru.specialist.java.spring.xml.device.screen.Screen;
import ru.specialist.java.spring.xml.device.storage.Storage;

import java.util.List;

public class Computer {

    private CPU cpu;

    private Screen screen;

    private List<Storage> storageList;

    private List<Memory> memoryList;

    public Computer() {
    }

//    public Computer(CPU cpu, Screen screen, List<Storage> storageList, List<Memory> memoryList) {
//        this.cpu = cpu;
//        this.screen = screen;
//        this.storageList = storageList;
//        this.memoryList = memoryList;
//    }

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

    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }
}
