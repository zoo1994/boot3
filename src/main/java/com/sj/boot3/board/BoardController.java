package com.sj.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sj.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "board";
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFilesVO boardFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFilesVO = boardService.getFileDetail(boardFilesVO);
		mv.addObject("fileVO",boardFilesVO);
		mv.setViewName("fileDown");
		return mv;
	}
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
	public ModelAndView add(BoardVO boardVO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardService.setAdd(boardVO,files);
		mv.setViewName("redirect:./list");
		return mv; 
	}
	
	@GetMapping("detail")
	public ModelAndView detail(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("vo",boardVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("vo",boardVO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(BoardVO boardVO, Model model)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardService.setUpdate(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardService.setDelete(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
}
