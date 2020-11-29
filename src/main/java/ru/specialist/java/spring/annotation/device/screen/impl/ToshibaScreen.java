package ru.specialist.java.spring.annotation.device.screen.impl;


import org.springframework.stereotype.Component;
import ru.specialist.java.spring.annotation.device.screen.Screen;

@Component("myToshibaScreen")
public class ToshibaScreen implements Screen {
    @Override
    public String getVendor() {
        return "is Toshiba vendor screen";
    }
}
