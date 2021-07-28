package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);
	public List<UserDTO> getUserList();
	public UserDTO getUser(String id);
	//public void modify(UserDTO userDTO);
	public int delete(String id); //삭제
	public void modify(Map<String, String> map);
	public List<UserDTO> search(Map<String, String> map);

}
