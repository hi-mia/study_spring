package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample05.SungJukDTO2;
import sample05.SungJukDelete;
import sample05.SungJukInput;
import sample05.SungJukModify;
import sample05.SungJukOutput;

@Configuration
public class SpringConfiguration { //빈을 생성해주는 파일(환경설정파일), xml과 같음

	//sample03
	//메소드명을 Bean명으로 인식한다
	@Bean
	public SungJukDTO sungJukDTO(){
		return new SungJukDTO();
	}
	
	@Bean
	public SungJukImpl sungJukImpl(){ //리턴되는 값 + 메소드명: 클래스이름(앞글자 소문자)
		return new SungJukImpl(); //일반 메소드x, 빈의 값을 리턴되는 애 값으로 함..
	}
	
//	@Bean(name="sungJukImpl")
//	public SungJukImpl getSungJukImpl(){
//		return new SungJukImpl();
//	}
	
	//sample05
	@Scope("prototype")
	@Bean(name="sungJukDTO2")
	public SungJukDTO2 getSungJukDTO2() {
		return new SungJukDTO2();
	}
	@Bean
	public List<SungJukDTO2> arrayList(){
		return new ArrayList<SungJukDTO2>();
	}
	@Bean(name="sungJukOutput")
	public SungJukOutput getSungJukOutput() {
		return new SungJukOutput();
	}
	@Bean(name="sungJukDelete")
	public SungJukDelete getSungJukDelete() {
		return new SungJukDelete();
	}
	@Bean(name="sungJukModify")
	public SungJukModify getSungJukModify() {
		return new SungJukModify();
	}
	@Scope("prototype")
	@Bean(name="sungJukInput")
	public SungJukInput getSungJukInput() {
		return new SungJukInput();
	}
	
}

//모든 자바파일은 반드시 생성해야 한다
//-new 클래스() (클래스 생성+생성자)
//@Configuration // 스프링 설정파일이라는 것을 알려줌, 이것들을 읽어내림.. 자바 static처럼