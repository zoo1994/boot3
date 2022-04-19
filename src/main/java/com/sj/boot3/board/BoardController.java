package com.sj.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sj.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("search",pager.getSearch());
		mv.addObject("pager",pager);
		mv.setViewName("board/list");
		return mv; 
	}
	
	@GetMapping("add")
	public ModelAndView add()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv; 
	}
	
	@PostMapping("add")
	public ModelAndView add(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardService.setAdd(boardVO);
		mv.setViewName("redirect:./list");
		return mv; 
	}
	
}
