package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate = null;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public void write(UserDTO userDTO) {
		String sql="insert into usertable values(?,?,?)"; //이름 아이디 패스워드
		jdbcTemplate.update(sql, userDTO.getName()
							   , userDTO.getId()
							   , userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql="select * from usertable";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); //한줄당 연결해서 userDTO에게 매칭 
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void modify(UserDTO userDTO) {
		String sql = "update usertable set name = ?, pwd = ? where id = ? ";
		jdbcTemplate.update(sql, userDTO.getName()
				   , userDTO.getPwd()
				   , userDTO.getId());	
	}

	@Override
	public int delete(String id) {
		String sql = "delete from usertable where id = ?";
		return jdbcTemplate.update(sql, id);
	}
}
*/

//public class UserDAOImpl extends JdbcDaoSupport implements UserDAO { //JdbcDaoSupport는 JdbcTemplate 갖고 있음, 상속으로 제공받는다
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {//파라메터에 이름을 주겠다
	@Override
	public void write(UserDTO userDTO) {
//		String sql="insert into usertable values(?,?,?)"; //이름 아이디 패스워드
//		getJdbcTemplate().update(sql, userDTO.getName()
//							   , userDTO.getId()
//							   , userDTO.getPwd());
		String sql="insert into usertable values(:name, :id, :pwd)";
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd",userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map); //맵에 담아서 가져와야 한다
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql="select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); //한줄당 연결해서 userDTO에게 매칭 
	}

	@Override
	public UserDTO getUser(String id) { //queryForObject 한 사람거만 가져온다 / rowMapper: 행단위로 db와 매칭시켜주는 거 
		String sql = "select * from usertable where id=?";
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (EmptyResultDataAccessException e) { //exception 일어나면 null로 보내라
			return null;
		}
	} //콜론 쓰려면 하나만 필요해도 맵에다 담아야 한다
	
	@Override
	public void modify(Map<String, String> map) { //스프링에서 map을 많이 쓴다.. 맵이 기본이라서
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public int delete(String id) {
		String sql = "delete usertable where id=:id";
		return getJdbcTemplate().update(sql, id);
	}



}
