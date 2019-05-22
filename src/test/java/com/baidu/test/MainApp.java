package com.baidu.test;

import com.baidu.bean.HelloIndia;
import com.baidu.bean.HelloWorld;
import com.baidu.bean.HelloWorldConfig;
import com.baidu.bean.Student;
import com.baidu.tutorialspoint.TextEditor;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    @Test
    public void test1(){
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj =(HelloWorld)factory.getBean("helloWorld");
        obj.getMessage();
    }

    @Test
    public void  test2(){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("I:\\springtest\\src\\main\\resources\\Beans.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        helloWorld.getMessage();
    }

    @Test
    public  void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA = (HelloWorld)context.getBean("helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();
        HelloWorld objB = (HelloWorld)context.getBean("helloWorld");
        objB.getMessage();

    }
    @Test
    public  void test4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans1.xml");
        HelloWorld objA = (HelloWorld)context.getBean("helloWorld");
        objA.getMessage();
        context.registerShutdownHook();

    }


    @Test
    public  void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans2.xml");
        HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
    }
    @Test
    public  void test6(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans3.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();
    }
    @Test
    public  void test7(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();
    }

    @Test
    public  void test8(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans6.xml");
        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
       // student.printThrowException();
    }

}
