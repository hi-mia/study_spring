package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("/user") //namespace /user가 공통되니 위에다 한번 써준다
public class UserController {
	@Autowired //자동으로 값 매핑
	private UserService userService=null;
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		//유저 서비스에 유저dto들고 가라
		userService.wirte(userDTO);
	}
	
	@RequestMapping(value="/checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		return userService.checkId(id);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
	/*
	@RequestMapping(value="/getUserList", method= RequestMethod.POST)
	@ResponseBody //Resolver 타고 가지 마라
	public JSONObject getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				UserDTO userDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name",userDTO.getName());
				temp.put("id",userDTO.getId());
				temp.put("pwd",userDTO.getPwd());
				
				array.add(i, temp); //배열에 붙는다
			}//for
			
			json.put("list", array);
		}
		
		return json;
	}
	*/
	
	/*
	 //위에 걸 간단하게 만든다
	@RequestMapping(value="/getUserList", method= RequestMethod.POST)
	@ResponseBody //Resolver 타고 가지 마라
	public Map getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		JSONArray array = JSONArray.fromObject(list); 
		Map map = new HashMap();//맵에 실어서 보내줘야한다
		map.put("list", array);
	
		return map;
	} 
	 */

	@RequestMapping(value="/getUserList", method= RequestMethod.POST)
	@ResponseBody //Resolver 타고 가지 마라
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getUser(@RequestParam String id) { //id전달하면 dto값이 그대로 끄집어나와야 함 + Json을 넘겨줌
		UserDTO userDTO = userService.getUser(id);
		 
		 JSONObject json = new JSONObject();
		 if(userDTO != null) {
			 json.put("name", userDTO.getName());
			 json.put("id", userDTO.getId());
			 json.put("pwd", userDTO.getPwd());
		 }
		 return json;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@RequestParam Map<String, String> map) { 
		userService.modify(map);
	}
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam String id) {
			userService.delete(id);
	}

	  @RequestMapping(value="/search", method=RequestMethod.POST)
      //list.js에서 1번과 2번형태로 왔을 때 (data) - 단순 문자열로 왔을 때   @RequestParam  --문자열 또는 MAP
      //public  @ResponseBody JSONObject search(@RequestParam Map<String, String>map) {
	  
      //list.js에서 3번형태로 왔을 때 (json의 형태로 그대로의 문자열로  왔기때문에 @RequestParam으로 못받음)
      public  @ResponseBody JSONObject search(@RequestBody Map<String, String> map) {
         List<UserDTO> list = userService.search(map); //디비로 갔다옴.. 디비에 있는 내용을 list로 갖고 옴
		
		JSONObject json = new JSONObject(); //제이슨 생성
		JSONArray array = new JSONArray(); //제이슨 배열 생성
			
			for(int i=0; i<list.size(); i++) {
				UserDTO userDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name",userDTO.getName());
				temp.put("id",userDTO.getId());
				temp.put("pwd",userDTO.getPwd());
				
				array.add(i, temp); //배열에 붙는다
			}//for
			
			json.put("list", array);
		
		return json;
	}
	
}
