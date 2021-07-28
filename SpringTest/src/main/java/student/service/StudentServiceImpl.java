package student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.bean.StudentDTO;
import student.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void write(StudentDTO studentDTO) {
		int tot=studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath();
		double avg=Double.parseDouble(String.format("%.2f", tot/3.0));
		
		studentDTO.setTot(tot);
		studentDTO.setAvg(avg);
		
		studentDAO.write(studentDTO);
	}

	@Override
	public List<StudentDTO> getStudent() {
		return studentDAO.getStudent();
	}

}
