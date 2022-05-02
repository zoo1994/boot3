package com.sj.boot3.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
