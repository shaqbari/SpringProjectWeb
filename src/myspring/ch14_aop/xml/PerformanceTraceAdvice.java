package myspring.ch14_aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메소드의 signature정보
		String signatureString = joinPoint.getSignature().toString();
		System.out.println(signatureString+"시작");
		
		//타겟의 메소드가 호출되기 전의 시간
		long start=System.currentTimeMillis();
				
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//time after calling target method
			long finish = System.currentTimeMillis();
			System.out.println(signatureString+"완료");
			System.out.println(signatureString+"실행시간:"+(finish-start)+"ms");
		}
		
		
	}
	
}
