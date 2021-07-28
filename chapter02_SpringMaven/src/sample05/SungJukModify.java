package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukModify implements SungJuk{
	@Qualifier("arrayList")
	@Autowired
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 이름 입력");
		String name = scan.next();
		int sw=0;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				System.out.println("이름 입력 : ");
				list.get(i).setName(scan.next());
				System.out.println("국어 점수 입력 : ");
				list.get(i).setKor(scan.nextInt());
				System.out.println("영어 점수 입력 : ");
				list.get(i).setEng(scan.nextInt());
				System.out.println("수학 점수 입력 : ");
				list.get(i).setMath(scan.nextInt());
				
				list.get(i).setTot(list.get(i).getKor() + list.get(i).getEng() + list.get(i).getMath());
				list.get(i).setAvg(list.get(i).getTot() / 3.0);
				sw++;
			}
		}

		if(sw==0) {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}else {
			System.out.println("수정 완료");
		}
	}

}