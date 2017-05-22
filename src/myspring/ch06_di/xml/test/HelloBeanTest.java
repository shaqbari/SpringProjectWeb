package myspring.ch06_di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.ch06_di.xml.Hello;
import myspring.ch06_di.xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		//1. Ioc 컨테이너 생성
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean 가져오기
		Hello hello=(Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();//stringPrinter의 stringbuffer에 hello + name의 value를 추가한다.
		
		//3.StringPrinter Bean 가져오기
		Printer printer = context.getBean("stringPrinter", Printer.class);
		System.out.println(printer.toString());
		
		Hello hello2=context.getBean("hello", Hello.class);
		System.out.println(hello==hello2);//true
		//IOC container가 spring bean을 singleton으로 관리하고 있음
		
	}

}
