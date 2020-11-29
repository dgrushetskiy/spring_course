package ru.specialist.java.spring.annotation.device.screen.impl;

import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.screen.Screen;

@Component
public class SonyScreen implements Screen {
    @Override
    public String getVendor() {
        return "is Sony vendor screen";
    }
}
