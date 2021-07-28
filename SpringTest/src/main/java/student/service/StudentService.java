package student.service;

import java.util.List;

import student.bean.StudentDTO;

public interface StudentService {

	public void write(StudentDTO studentDTO);

	public List<StudentDTO> getStudent();

}
