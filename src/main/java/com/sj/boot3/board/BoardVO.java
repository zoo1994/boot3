package com.sj.boot3.board;

import java.sql.Date;

import lombok.Data;
@Data
public class BoardVO {
	private Long num; //글번호
	private String title; //제목
	private String writer;//작성자
	private String contents;//글내용
	private Long hit;//조회수
	private Date regDate;//작성일
	private Long ref;
	private Long step;
	private Long depth;
	private Integer category;
}
