package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	
	@RequestMapping(value="/user/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
	@RequestMapping(value="/user/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/user/checkId", produces="application/String;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id) {
		String result = userService.checkId(id);
		System.out.println(result);
		
		return result;
	}
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	public @ResponseBody void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	public @ResponseBody void delete(@RequestParam String id) {
		userService.delete(id);
	}
	

	
//	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
//	@ResponseBody //jsp를 거치지 말라는 것. 이게 없으면 resolver 타고  jsp로 이동한다. 우선권은 viewResolver에게 있따. 
//	public JSONObject getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONObject json = new JSONObject();
//		
//		if(list != null) {
//			JSONArray array = new JSONArray();
//			for(int i=0;i<list.size();i++){
//				UserDTO userDTO = list.get(i);
//				
//				JSONObject temp = new JSONObject();
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(i, temp);
//			}
//			json.put("list", array);
//		}
//		
//		
//		
//		return json;
//	}
	
//	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONArray array = JSONArray.fromObject(list);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", array);
//		return map;
//	}
	
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList() { //modelandview는 json 쓸 때만 쓰는게 효울이 좋다.
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="/user/getUser", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getUser(@RequestParam String id) {
		System.out.println(id);
		UserDTO userDTO = userService.getUser(id);
		JSONObject json = new JSONObject();
		if(userDTO != null) {
			json.put("name", userDTO.getName());
			json.put("id", userDTO.getId());
			json.put("pwd", userDTO.getPwd());
		}
		
		return json;
	}
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
	@RequestMapping(value="/user/getSearchList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSearchList(@RequestParam String searchOption, String searchText) {
		System.out.println(searchOption + ", " + searchText);
		List<UserDTO> list = userService.getSearchList(searchOption, searchText);
		
		for(UserDTO dto : list) {
			System.out.println(dto.getName());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
}
