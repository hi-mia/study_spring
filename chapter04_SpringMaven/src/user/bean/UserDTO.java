package user.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDTO {
	
	private String name;
	private String id;
	private String pwd;
	
}
