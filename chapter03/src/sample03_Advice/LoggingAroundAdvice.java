package sample03_Advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//공통
		System.out.println("Around ---> 입실 체크");
		long start = System.currentTimeMillis(); //시작 시간 얻어옴
		
		Object ob = invocation.proceed();//핵심사항 호출 / Obejct 타입으로 받는다
		
		//공통
		long end = System.currentTimeMillis(); //종료 시간 얻어옴
		System.out.println((end-start)/1000 + "초");
		System.out.println("Around ---> 퇴실 체크");
		
		return ob;
	}
	//before, after는 자기거(공통)만 부르면 되지만 around는 핵심 코드도 불러줘야 한다
}
