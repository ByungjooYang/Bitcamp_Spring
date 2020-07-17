package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Have a nice day!!");
//		mav.setViewName("hello"); //hello.jsp
		mav.setViewName("/view/hello"); //servlet.xml에서 /view/ 를 없애고 이렇게 해도 되고 이걸 더 많이 쓴다.
		return mav;
	}

}


