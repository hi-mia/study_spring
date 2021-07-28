package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

//@Transactional
public class UserDAOMybatis implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}

	@Override
	@Transactional //커밋 필요한 애들한테만 이거 붙임.. 귀찮으면 클래스 머리 위에 붙이면 자동으로 처리함
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
	@Transactional
	public int delete(String id) {//커밋필요
		int su = sqlSession.delete("userSQL.delete", id);
		return su;
	}

	@Override
	@Transactional
	public void modify(Map<String, String> map) {//커밋필요
		sqlSession.update("userSQL.modify",map);

	}

}
