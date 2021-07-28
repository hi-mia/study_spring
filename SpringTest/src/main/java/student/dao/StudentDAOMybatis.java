package student.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import student.bean.StudentDTO;

@Repository
@Transactional
public class StudentDAOMybatis implements StudentDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(StudentDTO studentDTO) {
		sqlSession.insert("studentSQL.write", studentDTO);
	}

	@Override
	public List<StudentDTO> getStudent() {
		return sqlSession.selectList("studentSQL.getStudent");
	}

}
