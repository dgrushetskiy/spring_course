package ru.specialist.java.spring.javaconfig.device.storage.impl;

import ru.specialist.java.spring.javaconfig.device.storage.Storage;

public class ToshibaStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Toshiba vendor storage";
    }
}
