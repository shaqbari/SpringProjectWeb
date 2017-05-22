package myspring.ch08_setProperty.xml_test;

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

import java.util.List;
//static import�� �ϸ� �Ź� AssertŬ������ ���� �ʾƵ� �ȴ�.
/**
 * @author sakba
 * 	junit�� Ȯ���� spring-test�� �̿��غ���.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanPropertyTest {
	@Autowired	
	ApplicationContext context;//spring-test�� �̿��ϸ� �ڵ����� �������ش�.
		
	/**
	 * �׽�Ʈ�� ȣ��Ǳ� ���� init�� ȣ��ȴ�.
	 *//*
	@Before
	public void init(){
		
		context=new GenericXmlApplicationContext("config/beans.xml");
		
	}*/
	
	@Test 
	public void test1(){
		Hello hello=(Hello) context.getBean("hello2");
		assertEquals("HelloSpring2",  hello.sayHello());
		hello.print();//stringPrinter�� stringbuffer�� hello + name�� value�� �߰��Ѵ�.
		
		assertEquals(3, hello.getNames().size());
		List<String> list=hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}
		
		//3.StringPrinter Bean ��������
		Printer printer = context.getBean("stringPrinter", Printer.class);		
		assertEquals("HelloSpring2", printer.toString());
				
		
	}
	
	@Test @Ignore
	public void test2() {
		Hello hello=(Hello) context.getBean("hello");
		Hello hello2=(Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//IOC container�� spring bean�� singleton���� �����ϰ� ����
	}
	
}





