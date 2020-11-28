package ru.specialist.java.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.specialist.java.spring.javaconfig.device.Device;
import ru.specialist.java.spring.javaconfig.device.cpu.CPU;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Available Beans: " + Arrays.toString(ctx.getBeanDefinitionNames()));
        CPU cpu = (CPU)ctx.getBean("intelCPU");
        System.out.println(cpu.getVendor());

        Computer myComputer = (Computer)ctx.getBean("myComputer");
        System.out.println("CPU: " + myComputer.getCpu().getVendor());
        System.out.println("Screen: " + myComputer.getScreen().getVendor());
        System.out.println("Memory: " + myComputer.getMemoryList()
                .stream().map(Device::getVendor).collect(Collectors.joining(", ")));
        System.out.println("Storage: " + myComputer.getStorageList()
                .stream().map(Device::getVendor));

        Computer computer = (Computer)ctx.getBean("computer");
        System.out.println(myComputer.getCpu() == computer.getCpu());

    }
}
