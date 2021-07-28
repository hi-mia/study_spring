package sample05;

import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sungJukImpl")
@Scope("prototype")
public class SungJukImpl implements SungJuk {
		private String name;
		private int kor, eng, math;
		private int total;
		private double avg;

	public SungJukImpl() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력: ");
		name = scan.next();
		System.out.println("국어 입력: ");
		kor = scan.nextInt();
		System.out.println("영어 입력: ");
		eng = scan.nextInt();
		System.out.println("수학 입력: ");
		math = scan.nextInt();
	}
	
	@Override
	public void calc() { //총점, 평균 계산
		total = kor + eng + math;
		avg = (double)(kor + eng + math)/3;
		
	}

	@Override
	public void display() { //출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name + "\t" +
							kor + "\t" +
							eng + "\t" +
							math + "\t" +
							total + "\t" +
							Math.round(avg*1000)/1000.0);
	}

}
