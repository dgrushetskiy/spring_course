package ru.specialist.java.spring.annotation.device.storage.impl;

import ru.specialist.java.spring.annotation.device.storage.Storage;

public class ToshibaStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Toshiba vendor storage";
    }
}
