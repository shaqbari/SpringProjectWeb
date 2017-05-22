package myspring.ch09_di.annotation;

import org.springframework.stereotype.Component;

/**
 * @author sakba
 *	annotation�� component�� �ϰ� �ȿ� �̸��� ������ �ش�
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
