package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

//@ComponentScan("spring.conf")
@Repository //DB 빈 설정될 때 , ComponentScan대신 씀, 좀 더 상세히 밝혀줌
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	public void setDS(DataSource dataSource) { //진짜 필요한 데이터는 내가 아니라 NamedParameterJdbcDaoSupport가 가져야 함
		super.setDataSource(dataSource);//부모한테 직접 넘겨줌
	}
	
	@Override
	public void write(UserDTO userDTO) { 

		String sql="insert into usertable values(:name, :id, :pwd)";
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd",userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public List<UserDTO> getUserList() { 
		String sql="select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	
	public UserDTO getUser(String id) { //커밋 필요
		String sql = "select * from usertable where id=?";
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public void modify(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public int delete(String id) {
		String sql = "delete usertable where id=:id";
		return getJdbcTemplate().update(sql, id);
	}


}
