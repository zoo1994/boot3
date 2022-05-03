package com.sj.boot3.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private FileManager fileManager;

	@Autowired
	private MemberMapper memberMapper;
	//properties파일의 member.role.member 속성값 반환
	@Value("${member.role.member}")
	private String memberRole;
	
//사용자 정의 검증 메서드
	public boolean memberError(MemberVO memberVO , BindingResult bindingResult)throws Exception{
		boolean check =  false;
		//check= false 검증성공 error없음
		//check= true 검증실패 error있음
		//1. annotation 기본검증결과 
		check= bindingResult.hasErrors();
		//2password가 일치하는지 수동검증//뒤에 pw는 checkpw
		if(memberVO.getPw().equals(memberVO.getPw())) {
			check=true;
			bindingResult.rejectValue("checkPw","member.password.notEqul" );
		}
		return check;
	}
	
	public MemberVO findId(MemberVO memberVO)throws Exception{
		return memberMapper.findId(memberVO);
	}
	
	public int join(MemberVO memberVO, MultipartFile[] files)throws Exception{
		int result = memberMapper.join(memberVO);
		Map<String, String> map = new HashMap<>();
		map.put("id",memberVO.getId());
		map.put("roleName", memberRole);
		if(result>0) {
			for(MultipartFile mf : files) {
				if(mf.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(mf, "resources/upload/member/");
				MemberFilesVO memberFilesVO = new MemberFilesVO();
				memberFilesVO.setId(memberVO.getId());
				memberFilesVO.setFileName(fileName);
				memberFilesVO.setOriName(mf.getOriginalFilename());
				int result2 = memberMapper.fileAdd(memberFilesVO);
			}
			int result3 = memberMapper.setRoleAdd(map);
		}
		return result;
	}
	
	public MemberVO login(MemberVO memberVO)throws Exception{
		return memberMapper.login(memberVO);
	}
	
	public MemberVO myPage(MemberVO memberVO)throws Exception{
		return memberMapper.myPage(memberVO);
	}
	
	public int update(MemberVO memberVO)throws Exception{
		return memberMapper.update(memberVO);
	}
	
	public int delete(MemberVO memberVO)throws Exception{
		List<MemberFilesVO> ar = memberMapper.getFileList(memberVO);
		int result = memberMapper.delete(memberVO);
		if(result>0) {
			for(MemberFilesVO vo : ar) {
				fileManager.remove("resources/upload/member/", vo.getFileName());
			}
		}
		return result;
	}

}
