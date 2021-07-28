package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통관심사항
//Aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {//around는  어디까지가 핵심인지 알아야 한다
		//1. 앞부분에 삽입될 내용을 먼저 입력
		String methodName = joinPoint.getSignature().toShortString(); //toShortString() 간단하게 함수명만 꺼내와라
		System.out.println("메소드 = "+methodName);
		
		StopWatch sw = new StopWatch(); //스탑워치: 프로그램 실행속도 계산
		sw.start(methodName);
		
		Object ob = joinPoint.proceed(); //2. 핵심 사항 호출 **중요
		System.out.println("결과 ob = " + ob);
		
		//3. 코드 끼어들어갈 부분, 나머지 처리
		sw.stop();
		System.out.println("처리 시간 = " +sw.getTotalTimeMillis()/1000+"초");
	}
}
