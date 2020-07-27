package board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.service.BoardService;

@Controller
@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display", "/board/boardWriteForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	@ResponseBody
	public void boardWrite(@RequestParam Map<String, String> map) {
		boardService.boardWrite(map);
	}
	
//	@RequestMapping(value="getBoardList", method=RequestMethod.GET)
//	@ResponseBody
//	public String getBoardList(@RequestParam int pg, Model model){
//		System.out.println(pg);
//		List<BoardDTO> list = boardService.getBoardList(pg);
//		model.addAttribute("display", "/board/boardList.jsp");
//		
//		return "/main/index";
//	}
	
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(@RequestParam(required = false, defaultValue = "1")String pg, Model model){ //값이 없으면 디폴드 값으로 1을 준다.
		System.out.println(pg);
		//List<BoardDTO> list = boardService.getBoardList(pg);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardList.jsp");
		
		return "/main/index";
	}
	
	@RequestMapping(value="getBoardList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getBoardList(@RequestParam String pg) {
		List<BoardDTO> list = boardService.getBoardList(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
}
