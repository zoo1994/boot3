package com.sj.boot3.member;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private FileManager fileManager;

	@Autowired
	private MemberMapper memberMapper;
	
	public int join(MemberVO memberVO, MultipartFile[] files)throws Exception{
		int result = memberMapper.join(memberVO);
		if(result>0) {
			for(MultipartFile mf : files) {
				if(mf.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSava(mf, "resources/upload/member/");
				MemberFilesVO memberFilesVO = new MemberFilesVO();
				memberFilesVO.setId(memberVO.getId());
				memberFilesVO.setFileName(fileName);
				memberFilesVO.setOriName(mf.getOriginalFilename());
				int result2 = memberMapper.fileAdd(memberFilesVO);
			}
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
