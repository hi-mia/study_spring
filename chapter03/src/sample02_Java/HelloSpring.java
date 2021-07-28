package sample02_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean messageBean = new MessageBeanImpl();
		
		MessageBean proxy = (MessageBean) Proxy.newProxyInstance(  //프록시 생성 - 원래 스프링에는 내장되어 있다
				MessageBeanImpl.class.getClassLoader(),
				new Class[] {MessageBean.class}, //정확히 무슨 타입을 가지는지 모르니 퉁쳐서 class 타입이라고 표현함
				new InvocationHandler() { //익명 클래스 있어야지 생성이 된다, 임포트는 java.lang

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("입실 체크"); //공통
						
						Object ob = method.invoke(messageBean, args);//핵심 사항 호출
						
						System.out.println("퇴실 체크"); //공통
						
						return ob;
					} 

				});
		
		proxy.study();
		System.out.println("---------------------");
		System.out.println("결과 = " +  proxy.game());

	}

}
