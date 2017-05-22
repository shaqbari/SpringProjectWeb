package myspring.ch06_di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.ch06_di.xml.Hello;
import myspring.ch06_di.xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		//1. Ioc �����̳� ����
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean ��������
		Hello hello=(Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();//stringPrinter�� stringbuffer�� hello + name�� value�� �߰��Ѵ�.
		
		//3.StringPrinter Bean ��������
		Printer printer = context.getBean("stringPrinter", Printer.class);
		System.out.println(printer.toString());
		
		Hello hello2=context.getBean("hello", Hello.class);
		System.out.println(hello==hello2);//true
		//IOC container�� spring bean�� singleton���� �����ϰ� ����
		
	}

}
