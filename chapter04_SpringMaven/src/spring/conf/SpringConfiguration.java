package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import user.bean.UserDTO;
import user.dao.UserDAOImpl;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
public class SpringConfiguration {
    
	@Bean
	public BasicDataSource dataSource() { //데이터 소스값 불러오려면 이 함수 불러야 함
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		return basicDataSource;
	}
	
	@Bean
	public UserDAOImpl userDAO() { //리턴타입을 여기에다 넣는다.. userDAOImpl
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		userDAOImpl.setDataSource(dataSource()); //데이터소스 함수 호출
		return userDAOImpl;
	}
	
	
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	

	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	
	@Bean
	public UserInsertService userInsertService() {
		return new UserInsertService();
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService();
	}
	
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
	}
	
	
	
}
