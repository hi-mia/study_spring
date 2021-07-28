package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
@ComponentScan("spring.conf")
public class UserDAOMybatis implements UserDAO {
	
	@Setter
	//@Autowired - SpringConfiguration.java의 userDAOMybatis()에서 setter를 썼기 때문에 사용X
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public int delete(String id) {
		int su = sqlSession.delete("userSQL.delete", id);
		return su;
	}

	@Override
	public void modify(Map<String, String> map) {
		sqlSession.update("userSQL.modify",map);

	}

}
