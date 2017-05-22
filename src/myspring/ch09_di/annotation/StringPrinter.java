package myspring.ch09_di.annotation;

import org.springframework.stereotype.Component;

/**
 * @author sakba
 *	annotation에 component라 하고 안에 이름을 지정해 준다
 */
@Component("stringPrinter")
public class StringPrinter implements Printer {
	StringBuffer stringBuffer=new StringBuffer();
		
	public void print(String msg) {
		stringBuffer.append(msg);
	}
	
	public String toString() {
		return stringBuffer.toString();
	}

}
