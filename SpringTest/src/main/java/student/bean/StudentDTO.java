package student.bean;

import lombok.Data;

@Data
public class StudentDTO {
	private int studentId;
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private String image1;
}
