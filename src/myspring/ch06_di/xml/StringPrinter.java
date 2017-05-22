package myspring.ch06_di.xml;

public class StringPrinter implements Printer {
	StringBuffer stringBuffer=new StringBuffer();
		
	public void print(String msg) {
		stringBuffer.append(msg);
	}
	
	public String toString() {
		return stringBuffer.toString();
	}

}
