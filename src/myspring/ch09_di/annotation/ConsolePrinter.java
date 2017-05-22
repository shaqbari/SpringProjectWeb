package myspring.ch09_di.annotation;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinter implements Printer {

	public void print(String msg) {
		System.out.println(msg);
		
	}

}
