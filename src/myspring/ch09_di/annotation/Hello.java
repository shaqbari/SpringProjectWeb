package myspring.ch09_di.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sakba
 *	annotaion�� �̿��� bean �������踦 �����ϸ� setter�޼ҵ带 �̿��� �ʿ䰡 ����.
 */
@Component("hello")
public class Hello {
	//@Value("Spring")
	@Value("${myname}")//properties���Ͽ��� Spring
	private String name;

	/*@Autowired
	@Qualifier("stringPrinter")*/
	@Resource(name="${printer1}")
	private Printer printer;
	
	
	/*public Hello() {
		this.name = name;
		this.printer = printer;
	}
	
	//ctrl shift s + o : generate constructor using field	
	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
		
	}*/

/*	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}*/
		

	public String sayHello(){
		return "Hello"+ name;
	}
		
	public void print(){
		this.printer.print(sayHello());
		
	}
	
	
}
