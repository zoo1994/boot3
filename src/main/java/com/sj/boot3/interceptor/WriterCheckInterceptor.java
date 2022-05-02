package com.sj.boot3.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sj.boot3.board.BoardMapper;
import com.sj.boot3.board.BoardVO;
import com.sj.boot3.member.MemberVO;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor{
	
	@Autowired
	private BoardMapper boardMapper;
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		MemberVO memberVO=(MemberVO) request.getSession().getAttribute("member");
//		Map<String, Object> map = modelAndView.getModel();
//		BoardVO boardVO = (BoardVO)map.get("vo");
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
//			modelAndView.addObject("message","작성자만 가능합니다.");
//			modelAndView.addObject("path","./list");
//			modelAndView.setViewName("common/getResult");
//		}
//	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//String method = request.getMethod();
		
		
		String num1 = request.getParameter("num");
		Long num = Long.parseLong(num1);
		HttpSession session = request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		boardVO = boardMapper.getDetail(boardVO);
		if(boardVO.getWriter().equals(memberVO.getId())) {
			return true;
		}else{
			response.sendRedirect("./list");
			return false;
		}
	}
}
