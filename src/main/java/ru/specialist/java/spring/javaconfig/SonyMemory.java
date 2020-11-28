package ru.specialist.java.spring.javaconfig;

public class SonyMemory implements Memory {
    @Override
    public String getVendor() {
        return "Sony";
    }
}
