package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
@RequestMapping(value="member") // /member를 많이 쓰니 매번 쓰지 않도록 함. 슬래시를 빼도 된다.
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//===================================================== 로그인 로그아웃
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String, String> map, HttpSession session) {
		System.out.println(map.get("id"));
		MemberDTO memberDTO = memberService.login(map);
		String loginResult = null;
		
		if(memberDTO != null) {
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
			session.setAttribute("loginResult", loginResult);
			loginResult = "success";
			
		} else {
			loginResult = "fail";
			session.setAttribute("loginResult", loginResult);
		}
		
		return loginResult;
	}

	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		session.invalidate();
		
		return new ModelAndView("redirect:/main/index"); //=>main/index 를 바로 부른다.
	}
	
	//===============================================================회원가입
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute MemberDTO memberDTO, Model model) {
		memberService.write(memberDTO);
		
		model.addAttribute("display", "/member/write.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		return memberService.checkId(id);
	}
	
	//============================================== 주소
	
	@RequestMapping(value="checkPost", method=RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost";
	}
	
	@RequestMapping(value="postSearch", method=RequestMethod.POST)
	public ModelAndView postSearch(@RequestParam Map<String, String> map) {
		List<ZipcodeDTO> list = memberService.postSearch(map);
		System.out.println(list.get(0).getSido()+","+list.get(0).getSigungu()+list.get(0).getRoadname());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	} 
	
	//================================================ 회원정보 수정
	
	@RequestMapping(value="modifyForm", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		MemberDTO memberDTO = memberService.getMember(id);
		
		model.addAttribute("memberDTO", memberDTO);
		model.addAttribute("display", "/member/modifyForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public @ResponseBody void modify(@ModelAttribute MemberDTO memberDTO) {
		
		System.out.println(memberDTO.getName());
		memberService.modify(memberDTO);
	}
}