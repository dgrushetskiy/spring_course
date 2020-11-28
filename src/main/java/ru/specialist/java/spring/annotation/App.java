package ru.specialist.java.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Available Beans: " + Arrays.toString(ctx.getBeanDefinitionNames()));
//        CPU cpu = (CPU)ctx.getBean("intelCPU");
//        System.out.println(cpu.getVendor());

        Computer myComputer = (Computer)ctx.getBean(Computer.class);
        System.out.println("CPU: " + myComputer.getCpu().getVendor());
        System.out.println("Memory: " + myComputer.getMemoryList()
                .stream().map(Device::getVendor).collect(Collectors.joining(", ")));

    }
}
