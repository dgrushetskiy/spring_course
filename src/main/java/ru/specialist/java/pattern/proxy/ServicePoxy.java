package ru.specialist.java.pattern.proxy;

public class ServicePoxy implements Service {

    private Service service = new ServiceImpl();

    @Override
    public void doSomething() {
        System.out.println("Call calling");
        service.doSomething();
        System.out.println("After calling");
    }
}
