package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	public void wirte(UserDTO userDTO);
	public String checkId(String id);
	public UserDTO getUser(String id);
	public List<UserDTO> getUserList();
	public void modify(Map<String, String> map);
	public void delete(String id);
	public List<UserDTO> search(Map<String, String> map);
}
