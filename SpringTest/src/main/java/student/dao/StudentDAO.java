package student.dao;

import java.util.List;

import student.bean.StudentDTO;

public interface StudentDAO {

	public void write(StudentDTO studentDTO);

	public List<StudentDTO> getStudent();

}
