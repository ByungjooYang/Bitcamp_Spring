package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller //핸들러 매핑이 찾아올 수 잇게 함.
public class HelloController {
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody String hello() {
//		return "안녕하세요"; //responseBody는 리턴 값을 단순 문자열로 보라는 것이다.
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONObject hello() {
//		JSONObject json = new JSONObject();
//		json.put("name", "hong");
//		json.put("age", "25");
//		
//		return json;
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONArray hello() {
//		JSONArray array = new JSONArray();
//		
//		JSONObject json = new JSONObject();
//		json.put("name", "hong");
//		json.put("age", "25");
//		array.add(0, json);
//		
//		json.put("name", "conan");
//		json.put("age", "17");
//		array.add(1, json);	//객체를 또 생성하지 않아도 된다.
//		
//		return array;
//	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONObject hello() {
		JSONArray array = new JSONArray();
		
		JSONObject json = new JSONObject();
		json.put("name", "hong");
		json.put("age", "25");
		array.add(0, json);
		
		json.put("name", "conan");
		json.put("age", "17");
		array.add(1, json);	//객체를 또 생성하지 않아도 된다.
		
		JSONObject list = new JSONObject();
		list.put("list", array); // array에 이름을 지정
		
		return list;
	}

}
