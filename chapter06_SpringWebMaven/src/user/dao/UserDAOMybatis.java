package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
@Repository
public class UserDAOMybatis implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) { //커밋이 필요
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {//커밋 필요X
		return sqlSession.selectList("userSQL.getUserList"); //selectList가 알아서 list 리턴해서 그냥 이렇게 쓰면 됨
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}


	@Override
	public void modify(Map<String, String> map) {//커밋필요
		sqlSession.update("userSQL.modify",map);
	}


	@Override
	public int delete(String id) {//커밋필요
		return sqlSession.delete("userSQL.delete", id);
	}
	
	public List<UserDTO> search(Map<String, String> map) {
		return sqlSession.selectList("userSQL.search", map); //map을 들고 간다 / selectList자체가 list를 만들어서 나에게 보내준다
		
	}

}
