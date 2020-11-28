package ru.specialist.java.spring.xml;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Available Beans: " + Arrays.toString(ctx.getBeanDefinitionNames()));
        CPU cpu = (CPU)ctx.getBean("intelCPU");
        System.out.println(cpu.getVendor());

        Computer computer = ctx.getBean(Computer.class);
        System.out.println("CPU: " + computer.getCpu().getVendor());
        System.out.println("Memory: " + computer.getMemoryList()
                .stream().map(Device::getVendor).collect(Collectors.joining(", ")));

    }
}
