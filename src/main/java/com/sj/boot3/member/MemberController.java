package com.sj.boot3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sj.boot3.board.BoardService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "member";
	}
	
	@PostMapping("update")
	public ModelAndView update(MemberVO memberVO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO2 = (MemberVO)session.getAttribute("member");
		memberVO.setId(memberVO2.getId());
		int result = memberService.update(memberVO);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(HttpSession session,MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.delete(memberVO);
		String message = "회원탈퇴 실패";
		String path = "./mypage";
		if(result>0) {
			message = "회원탈퇴 성공";
			session.invalidate();
			path = "/";
		}
		mv.addObject("path",path);
		mv.addObject("message",message);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("myPage")
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.myPage(memberVO);
		mv.addObject("vo",memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView login(HttpSession session, MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.login(memberVO);
		String message = "로그인 실패";
		String path = "./login";
		if(memberVO!=null) {
			message="로그인 성공";
			path = "/";
			session.setAttribute("member",memberVO);
		}
		mv.addObject("path",path);
		mv.addObject("message",message);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberVO memberVO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.join(memberVO,files);
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
