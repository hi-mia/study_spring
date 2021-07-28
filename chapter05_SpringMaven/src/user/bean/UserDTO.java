package user.bean;

import org.springframework.context.annotation.ComponentScan;

import lombok.Data;

@ComponentScan("spring.conf")
@Data
public class UserDTO {
	
	private String name;
	private String id;
	private String pwd;
	
}
