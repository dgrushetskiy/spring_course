package ru.specialist.java.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Computer {



//    @Autowired
//    @Qualifier("myCpu")
    private CPU cpu;


//    @Autowired
    private List<Memory> memoryList;


    public Computer() {

    }

//    @Autowired
    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

    @Autowired
    public Computer(CPU cpu, @Qualifier("listOfMemory") List<Memory> memoryList) {
        this.cpu = cpu;
        this.memoryList = memoryList;
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

//    @Autowired
    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }
}
