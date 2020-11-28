package ru.specialist.java.spring.annotation;

//@Component("myCpu")
public class IntelCPU implements CPU {
    @Override
    public String getVendor() {
        return "Intel";
    }
}
