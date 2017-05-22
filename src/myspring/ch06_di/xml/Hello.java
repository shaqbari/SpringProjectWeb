package myspring.ch06_di.xml;

import java.util.List;

public class Hello {
	private String name;
	private Printer printer;
	private List<String> names;
	
	public Hello() {
		this.name = name;
		this.printer = printer;
	}
	
	//ctrl shift s + o : generate constructor using field	
	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public List<String> getNames() {
		return names;
	}
	
	public String sayHello(){
		return "Hello"+ name;
	}
		
	public void print(){
		this.printer.print(sayHello());
		
	}
	
	
}
