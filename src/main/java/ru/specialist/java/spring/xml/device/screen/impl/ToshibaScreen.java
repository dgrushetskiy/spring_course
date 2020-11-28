package ru.specialist.java.spring.xml.device.screen.impl;


import ru.specialist.java.spring.annotation.device.screen.Screen;

public class ToshibaScreen implements Screen {
    @Override
    public String getVendor() {
        return "is Toshiba vendor screen";
    }
}
