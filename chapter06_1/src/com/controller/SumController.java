package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SumDTO;

//나는 컨트롤러다 하고 알려줌 그래야 찾아옴
@Controller
public class SumController {

//		@RequestMapping(value="/input.do", method=RequestMethod.GET)
//		public ModelAndView input() {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("/sum/input");
//			return mav;
//		}
	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	//리턴타입이 String이고 앞에 @ResponseBody를 안걸어주면 단순 문자열이 아니라 뷰의 이름(jsp의 파일명)으로 인식한다. 
	public String input() {		
		return "/sum/input";			 
	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public String result() {
//		return "/sum/result";
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam int x, @RequestParam int y) { //데이터 실어갈거라서
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required=false, defaultValue="0") String x, 
//								@RequestParam(required=false, defaultValue="0") String y) { //데이터 실어갈거라서
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public String result(@RequestParam Map<String, Integer> map, ModelMap modelMap) { //ModelAndView를 대신해서 씀
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		return "/sum/result";
//	}
	
	//회원가입같은 경우 들어오는 데이터가 너~무 많아. 그래서 map에 담기도 뭐해. 그래서 DTO에 잡아줘
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x",sumDTO.getX());
		model.addAttribute("y",sumDTO.getY());
		
		return "/sum/result";
		
	}
		
}
