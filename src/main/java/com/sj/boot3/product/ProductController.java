package com.sj.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sj.boot3.member.MemberVO;
import com.sj.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(ProductFilesVO fileVO)throws Exception{
		ModelAndView mv = new ModelAndView();

		int result = productService.fileDelete(fileVO);

		mv.addObject("result",result);
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(ProductVO productVO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = productService.setUpdate(productVO,files);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(ProductVO productVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		productVO = productService.getDetail(productVO);
		int count = productVO.getFilesVO().size();
		mv.addObject("count",count);
		mv.addObject("vo",productVO);
		mv.setViewName("product/update");
		return mv;
	}
	
	@GetMapping("manageDetail")
	public ModelAndView getManageDetail(ProductVO productVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		productVO = productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/manageDetail");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(ProductVO productVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		productVO = productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("manage")
	public ModelAndView manage(HttpSession session,Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.getListManage(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("product/manage");
		return mv;
	}
	
	@GetMapping("ajaxList")
	public ModelAndView ajaxList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("common/ajaxList");
		return mv;
	} 
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("product/list");
		return mv;
	} 
	
	@GetMapping("add")
	public ModelAndView setAdd()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(ProductVO productVO,MultipartFile[] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
		
		int result = productService.setAdd(productVO,files);
		mv.addObject("result",result);
		mv.setViewName("common/result");
		return mv;
	}
}
