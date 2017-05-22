package myspring.ch14_aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼ҵ��� signature����
		String signatureString = joinPoint.getSignature().toString();
		System.out.println(signatureString+"����");
		
		//Ÿ���� �޼ҵ尡 ȣ��Ǳ� ���� �ð�
		long start=System.currentTimeMillis();
				
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//time after calling target method
			long finish = System.currentTimeMillis();
			System.out.println(signatureString+"�Ϸ�");
			System.out.println(signatureString+"����ð�:"+(finish-start)+"ms");
		}
		
		
	}
	
}
