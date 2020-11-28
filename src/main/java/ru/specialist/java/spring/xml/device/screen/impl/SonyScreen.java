package ru.specialist.java.spring.xml.device.screen.impl;

import ru.specialist.java.spring.annotation.device.screen.Screen;

public class SonyScreen implements Screen {
    @Override
    public String getVendor() {
        return "is Sony vendor screen";
    }
}
