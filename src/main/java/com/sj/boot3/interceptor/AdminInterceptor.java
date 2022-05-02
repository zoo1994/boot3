package com.sj.boot3.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sj.boot3.member.MemberVO;
import com.sj.boot3.member.RoleVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	
	@Value("${member.role.admin}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO!=null) {
			for(RoleVO vo : memberVO.getRoleVOs()) {
				if(vo.getRoleName().equals(roleName)) {
					check = true;
				}
			}
		}
		if(!check) {
			//mv.addObject("키",벨류)와 같음
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("path", "../");
			//mv.setViewName();와 같음
			//WEB-INF/views 경로와 .jsp까지 직접 작성해야함
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/getResult.jsp");
			
			view.forward(request, response);
		}		
		return check;
	}
}
