package ru.specialist.java.spring.annotation.device.storage.impl;

import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.storage.Storage;

@Component
public class SonyStorage implements Storage {
    @Override
    public String getVendor() {
        return "is Sony vendor storage";
    }
}
