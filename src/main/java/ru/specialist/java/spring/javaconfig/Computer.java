package ru.specialist.java.spring.javaconfig;

import ru.specialist.java.spring.javaconfig.device.cpu.CPU;
import ru.specialist.java.spring.javaconfig.device.memory.Memory;
import ru.specialist.java.spring.javaconfig.device.screen.Screen;
import ru.specialist.java.spring.javaconfig.device.storage.Storage;

import java.util.List;

public class Computer {

    private CPU cpu;

    private List<Memory> memoryList;

    private Screen screen;

    private List<Storage> storageList;

    public Computer() {

    }

    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

    public Computer(CPU cpu, List<Memory> memoryList) {
        this.cpu = cpu;
        this.memoryList = memoryList;
    }

    public Computer(CPU cpu, List<Memory> memoryList, Screen screen, List<Storage> storageList) {
        this.cpu = cpu;
        this.memoryList = memoryList;
        this.screen = screen;
        this.storageList = storageList;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
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
}
