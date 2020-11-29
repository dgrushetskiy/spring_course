package ru.specialist.java.spring.annotation.device.storage.impl;

import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.storage.Storage;

@Component
public class ToshibaStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Toshiba vendor storage";
    }
}
