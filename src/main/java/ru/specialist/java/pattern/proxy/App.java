package ru.specialist.java.pattern.proxy;

public class App {

    public static void main(String[] args) {
        Service service = new ServicePoxy();
//                new ServiceImpl();
        service.doSomething();
    }
}
