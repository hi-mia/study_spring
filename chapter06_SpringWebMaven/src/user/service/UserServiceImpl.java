package user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void wirte(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}
	
	@Override
	public String checkId(String id) {
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null)
			return "non_exist"; //id가 없다 ---> 사용 가능
		else
			return "exist";
	}

	@Override
	public List<UserDTO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);		
	}

	@Override
	public void modify(Map<String, String> map) {
		userDAO.modify(map);
		
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		return userDAO.search(map);
		
	}

}
