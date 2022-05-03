package com.sj.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank(message="id좀 입력해라")
	private String id;
	@Size(min=2,max=8,message="2글자이상 8이하 입력해라")
	private String pw;
	@NotBlank(message="이름입력")
	private String name;
	@Email(message="이메일형식")
	private String email;
	private String phone;
	private List<MemberFilesVO> filesVOs;
	private List<RoleVO> roleVOs;
}
