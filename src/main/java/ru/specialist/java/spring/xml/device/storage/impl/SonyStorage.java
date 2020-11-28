package ru.specialist.java.spring.xml.device.storage.impl;

import ru.specialist.java.spring.annotation.device.storage.Storage;

public class SonyStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Sony vendor storage";
    }
}
