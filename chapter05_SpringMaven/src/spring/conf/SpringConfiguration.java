package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
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
	
	//아이디로 함수명/메소드명을 잡아줘야 한다
	public SqlSessionFactory sqlSessionFactory() throws Exception{ //applicationContext에 있는 SqlSessionFactory를 여기에 넘겨준다
		  SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		  sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		  sqlSessionFactoryBean.setDataSource(dataSource());
		  sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
		  	return sqlSessionFactoryBean.getObject(); //SqlSessionFactory 리턴, 부모를 리턴한다
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception { //생성자는 강제호출 불가
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){ //커밋하려면 데이터소스/커넥션 풀 필요하다
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
	
	//@ComponentScan("spring.conf") 쓰면 여기에 다 등록해줘야 함
	@Bean
	public HelloSpring helloSpring(){
		return new HelloSpring();
	}
	
	@Bean
	public UserInsertService userInsertService() {
		return new UserInsertService();
	}
	
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@Bean
	public UserDAOMybatis userDAOMybatis() throws Exception {  //userDAOMybatis는 SqlSession를 꼭 가지고 있어야 함.. setter 잡아줘야함
		UserDAOMybatis userDAOMybatis = new UserDAOMybatis();
		userDAOMybatis.setSqlSession(sqlSession()); //setter 필요 - UserDAOMybatis에 autowired 대신 setter 사용 / autowired 사용하면 이거 지우면 됨
		return userDAOMybatis;
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService();
	}

	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
	}
	
}
