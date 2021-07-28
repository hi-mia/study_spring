package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

//@Component
@Controller //컨트롤러가 컴포넌트 역할도 한다
public class SungJukController {

	@RequestMapping(value="/sungJuk/input.do",method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}
	
	@RequestMapping(value="/sungJuk/result.do",method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO sungJukDTO , Model model) {
		sungJukDTO.setTot(sungJukDTO.getEng() + sungJukDTO.getKor() + sungJukDTO.getMath());
		sungJukDTO.setAvg(Double.parseDouble(String.format("%.3f", sungJukDTO.getTot() / 3.0)));
		model.addAttribute("sungJukDTO", sungJukDTO); //모델 안에다 dto를 통으로 직접 실어서 넣는다

		return "/sungJuk/result";
	}
		
}
