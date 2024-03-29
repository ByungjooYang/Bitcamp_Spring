package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET) //얘는 주소치고 오는애라 get으로 하믄 됨.
	public String input() {
		return "/sungJuk/input";
	}
	
	@RequestMapping(value="/sungJuk/result.do", method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		double avg = tot/3.0;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		modelMap.addAttribute("sungJukDTO", sungJukDTO);
		
		return "/sungJuk/result";
	}
	
}
