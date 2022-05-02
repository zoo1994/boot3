package com.sj.boot3.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public int setRoleAdd(Map<String, String> map)throws Exception;
	public int join(MemberVO memberVO)throws Exception;
	public MemberVO login(MemberVO memberVO)throws Exception;
	public MemberVO myPage(MemberVO memberVO)throws Exception;
	public int update(MemberVO memberVO)throws Exception;
	public int delete(MemberVO memberVO)throws Exception;
	public int fileAdd(MemberFilesVO memberFilesVO)throws Exception;
	public List<MemberFilesVO> getFileList(MemberVO memberVO)throws Exception;
	
}
