package ru.specialist.java.spring.javaconfig.device.screen.impl;


import ru.specialist.java.spring.annotation.device.screen.Screen;

public class ToshibaScreen implements Screen {
    @Override
    public String getVendor() {
        return "is Toshiba vendor screen";
    }
}
