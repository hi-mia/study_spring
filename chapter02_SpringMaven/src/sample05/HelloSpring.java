package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("helloSpring")
public class HelloSpring {
	
	public void menu() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num = 0;

		while(true) {
			
			System.out.println("**************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("**************");
			System.out.print("     번호:");
			num = scan.nextInt();
			
			if(num==5) break;
			
			if(num==1) sungJuk = (SungJuk) context.getBean("sungJukInput");
				//sungJuk = new SungJukInput(); //부모로 잡는다
			else if(num==2) sungJuk = (SungJuk) context.getBean("sungJukOutput");
				//sungJuk = new SungJukOutput();
			else if(num==3) {
				sungJuk = (SungJukModify)context.getBean("sungJukModify");
			}else if(num==4) {
				sungJuk = (SungJukDelete)context.getBean("sungJukDelete");
			}else System.out.println("1~5 사이의 숫자를 입력해주세요");
			
			sungJuk.execute(); //호출
		}//while
		
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		
		helloSpring.menu();
		System.out.println("프로그램을 종료합니다");
	}
	
}
