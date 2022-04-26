package com.sj.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.sj.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
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
	public ModelAndView setAdd(ProductVO productVO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = productService.setAdd(productVO,files);
		mv.addObject("result",result);
		mv.setViewName("common/result");
		return mv;
	}
}
