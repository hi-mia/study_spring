package student.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import student.bean.StudentDTO;
import student.service.StudentService;

@Controller
@RequestMapping(value="student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="writeForm",method=RequestMethod.GET)
	public String writeForm() {
		return "/student/writeForm";
	}
		
		
	//한 번에 여러 개의 파일을 선택했을 때
		@RequestMapping(value="write", method=RequestMethod.POST)
		@ResponseBody
		public void write(@ModelAttribute StudentDTO studentDTO,
									@RequestParam("img[]") List<MultipartFile> list) { //이미지 배열타입을 리스트로 받음
			
			String filePath = "D:\\Spring\\workspace\\SpringTest\\src\\main\\webapp\\storage";
			String fileName;
			File file;
			
			for(MultipartFile img : list) {
				fileName = img.getOriginalFilename();
				file = new File(filePath, fileName);
				
				//파일 복사
				try {
					FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
				}catch (IOException e) {
					e.printStackTrace();
				}
				
				studentDTO.setImage1(fileName);
			
				//DB
				studentService.write(studentDTO); //함수 이름과 똑같이 imageboardWrite라고 함+dto들고 감
			
				//jsp로 가서 본다
				
			} //for
		}
	
		//list 
		@RequestMapping(value="ListForm",method=RequestMethod.GET)
		public String ListForm() {
			return "/student/ListForm";
		}
		
		@RequestMapping(value="getStudent", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getStudent() {
			
			List<StudentDTO> list = studentService.getStudent();
			
	    	ModelAndView mav = new ModelAndView();
	    	mav.addObject("list", list);
			
	      	mav.setViewName("jsonView"); //json으로 자동으로 변환
	    	return mav;
		}

		
}
