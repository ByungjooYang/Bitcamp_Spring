package member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
@RequestMapping(value="member") // /member를 많이 쓰니 매번 쓰지 않도록 함. 슬래시를 빼도 된다.
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String, String> map, HttpSession session) {
		System.out.println(map.get("id"));
		MemberDTO memberDTO = memberService.login(map);
		String loginResult = null;
		
		if(memberDTO != null) {
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
			
			loginResult = "success";
			
		} else {
			loginResult = "fail";
			
		}
		
		return loginResult;
	}
//	@RequestMapping(value="logout", method=RequestMethod.POST)
//	public String logout(HttpSession session, Model model) {
//		session.invalidate();
//		model.addAttribute("display", "/template/body.jsp");
//		
//		return "main/index";
//	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		session.invalidate();
		
		return new ModelAndView("redirect:/main/index"); //=>main/index 를 바로 부른다.
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		return memberService.checkId(id);
	}
	@RequestMapping(value="checkPost", method=RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost";
	}
}