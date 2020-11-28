package ru.specialist.java.spring.javaconfig.device.storage.impl;

import ru.specialist.java.spring.javaconfig.device.storage.Storage;

public class SonyStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Sony vendor storage";
    }
}
