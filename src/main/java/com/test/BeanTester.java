package com.test;

import com.practice.bean.Mouse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTester {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        Mouse mouse = (Mouse) applicationContext.getBean("mouse");
        System.out.println(mouse);
    }
}
