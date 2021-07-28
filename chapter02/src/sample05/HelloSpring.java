package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		//HelloSpring helloSpring = new HelloSpring();
		
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다");
	}

	
	public void menu(ApplicationContext context) {
		
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
				sungJuk = context.getBean("sungJukModify", SungJuk.class); //부모로 잡아야 한다
			}else if(num==4) {
				sungJuk = context.getBean("sungJukDelete", SungJuk.class);
			}else System.out.println("1~5 사이의 숫자를 입력해주세요");
			sungJuk.execute(); //호출
			
		}//while

	}
	
}
