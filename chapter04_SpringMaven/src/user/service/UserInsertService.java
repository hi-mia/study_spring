package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service //일반적인 bean이 아니라 service, 처리하는 부분이다, 하고 좀 더 자세히 밝혀주는 거, component 써도 된다
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		//입력
		Scanner scan = new Scanner(System.in);
		System.out.print("이름입력: "); 
		String name = scan.next();
		System.out.print("아이디 입력: "); 
		String id = scan.next();
		System.out.print("비밀번호 입력 : "); 
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		userDAO.write(userDTO);
		
		//응답
		System.out.println("데이터를 DB에 저장하였습니다.");

	}

}
