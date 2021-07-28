package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;

@EnableAspectJAutoProxy //여기엔 aop 기능도 있다는 것을 알려준다
@Configuration //일반 자바가 아닌 설정 파일임을 알려줌
public class SpringConfiguration {
	
	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}
	
	@Bean
	public MessageBeanImpl messageBeanImpl(){ //MessageBeanImpl 생성해주려고 함
		return new MessageBeanImpl();
	}
}
