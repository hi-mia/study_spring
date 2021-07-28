package sample04_Advisor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("퇴실 체크"); //공통
		//before, after는 자기거(공통)만 부르면 되지만 around는 핵심 코드도 불러줘야 한다
		
	}

}
