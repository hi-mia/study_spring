package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean bean = (MessageBean)context.getBean("messageBeanImpl");
		
		//bean.showPrintBefore();
		//bean.showPrintAfter();
		System.out.println("main = " + bean.showPrint());
		System.out.println("---------------");
		//bean.viewPrintBefore();
		//bean.viewPrintAfter();
		bean.viewPrint();
		System.out.println("---------------");
		bean.display();
		System.out.println("---------------");

	}

}
