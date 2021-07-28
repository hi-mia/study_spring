package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //@ComponentScan("spring.conf")
@Scope("prototype")
public class SungJukInput implements SungJuk{
	@Qualifier("arrayList")
	@Autowired
	private List<SungJukDTO2> list;
	@Autowired
	private SungJukDTO2 sungJukDTO2;

	@Override
	public void execute() {
		System.out.println("list 전 길이 : " + list.size());
		//데이터 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		String name = scan.next();
		
		//list에 동일한 이름이 있는지 체크
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				System.out.println("동일한 이름 존재");
				return;
			}
		}
		sungJukDTO2.setName(name);
		System.out.println("국어 점수 입력 : ");
		sungJukDTO2.setKor(scan.nextInt());
		System.out.println("영어 점수 입력 : ");
		sungJukDTO2.setEng(scan.nextInt());
		System.out.println("수학 점수 입력 : ");
		sungJukDTO2.setMath(scan.nextInt());
		
		//데이터 계산
		sungJukDTO2.setTot(sungJukDTO2.getKor() + sungJukDTO2.getEng() + sungJukDTO2.getMath());
		sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);
		
		//데이터 저장
		list.add(sungJukDTO2);
		
		System.out.println("list 후 길이 : " + list.size());
	}

}
