package com.Controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Component //빈 설정 or component
@Controller
public class HelloController {

//	@RequestMapping(value="/hello.do", method=RequestMethod.GET) //컨트롤러 찾아서 여기까지 와라
//	@ResponseBody - 리턴 타입이 String일 때 단순 문자열로 인식한다
//	public @ResponseBody String hello() { //사용자가 만든 콜백메소드 - 스프링의 특징 / 절대 내가 만드는/호출하는 거X + request, response 하나도 안 씀
//		return "Have a nice day!!";
//	}
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello SpringMVC");
		//mav.setViewName("hello");
		mav.setViewName("/view/hello");
		return mav;
	}
	
}	
