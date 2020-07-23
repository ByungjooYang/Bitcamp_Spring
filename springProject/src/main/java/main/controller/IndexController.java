package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value = "/main/index", method = RequestMethod.GET)
	public String index(Model model) { //아니면 String 대신 ModelAndView 로 잡아줘도 된다.
		model.addAttribute("display", "/template/body.jsp");
		return "/main/index";
	}
}
