package myspring.ch07_junit.xml_test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.ch06_di.xml.Hello;
import myspring.ch06_di.xml.Printer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
//static import�� �ϸ� �Ź� AssertŬ������ ���� �ʾƵ� �ȴ�.
/**
 * @author sakba
 * 	junit�� Ȯ���� spring-test�� �̿��غ���.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	@Autowired	
	ApplicationContext context;//spring-test�� �̿��ϸ� �ڵ����� �������ش�.
		
	/**
	 * �׽�Ʈ�� ȣ��Ǳ� ���� init�� ȣ��ȴ�.
	 *//*
	@Before
	public void init(){
		
		context=new GenericXmlApplicationContext("config/beans.xml");
		
	}*/
	
	@Test @Ignore
	public void test1(){
		/*//1. Ioc �����̳� ����
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");*/
		
		//2. Hello Bean ��������
		Hello hello=(Hello) context.getBean("hello");
		/*System.out.println(hello.sayHello());*/
		/*Assert.assertEquals("HelloSpring", hello.sayHello());*/
		assertEquals("HelloSpring",  hello.sayHello());
		
		hello.print();//stringPrinter�� stringbuffer�� hello + name�� value�� �߰��Ѵ�.
		
		//3.StringPrinter Bean ��������
		Printer printer = context.getBean("stringPrinter", Printer.class);
		//System.out.println(printer.toString());
		//assertEquals("Hello Spring", printer.toString()); ��������.
		//junitâ���� ��� Ȯ�ΰ���
		assertEquals("Hello Spring", printer.toString());
				
		
	}
	
	@Test
	public void test2() {
		Hello hello=(Hello) context.getBean("hello");
		Hello hello2=(Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//IOC container�� spring bean�� singleton���� �����ϰ� ����
	}
	
}





