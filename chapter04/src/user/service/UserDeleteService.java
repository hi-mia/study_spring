package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
		int su = userDAO.delete(id);
		
		if(su==0) 
			System.out.println("삭제할 아이디가 없습니다");
		else
			System.out.println("데이터를 DB에서 삭제하였습니다");
		

	}

}
