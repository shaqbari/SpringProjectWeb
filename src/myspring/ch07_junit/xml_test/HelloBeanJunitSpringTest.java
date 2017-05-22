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
//static import를 하면 매번 Assert클래스를 쓰지 않아도 된다.
/**
 * @author sakba
 * 	junit를 확장한 spring-test를 이용해본다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	@Autowired	
	ApplicationContext context;//spring-test를 이용하면 자동으로 맵핑해준다.
		
	/**
	 * 테스트가 호출되기 전에 init가 호출된다.
	 *//*
	@Before
	public void init(){
		
		context=new GenericXmlApplicationContext("config/beans.xml");
		
	}*/
	
	@Test @Ignore
	public void test1(){
		/*//1. Ioc 컨테이너 생성
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");*/
		
		//2. Hello Bean 가져오기
		Hello hello=(Hello) context.getBean("hello");
		/*System.out.println(hello.sayHello());*/
		/*Assert.assertEquals("HelloSpring", hello.sayHello());*/
		assertEquals("HelloSpring",  hello.sayHello());
		
		hello.print();//stringPrinter의 stringbuffer에 hello + name의 value를 추가한다.
		
		//3.StringPrinter Bean 가져오기
		Printer printer = context.getBean("stringPrinter", Printer.class);
		//System.out.println(printer.toString());
		//assertEquals("Hello Spring", printer.toString()); 오류난다.
		//junit창에서 결과 확인가능
		assertEquals("Hello Spring", printer.toString());
				
		
	}
	
	@Test
	public void test2() {
		Hello hello=(Hello) context.getBean("hello");
		Hello hello2=(Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
		//IOC container가 spring bean을 singleton으로 관리하고 있음
	}
	
}





