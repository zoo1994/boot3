package com.sj.boot3.util;

import lombok.Data;

@Data
public class Pager {
	//db에서 몇개씩 조회
	private Integer perPage;
	
	//page 번호(파라미터 값)
	private Integer pageNum;
	
	//DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	private String search;
	private Integer kind;
	
	public void makeRow() {
		//pageNum : 1 , perPage : 10 ,startRow : 0
		//pageNum : 2 , perPage : 10 ,startRow : 10
		//pageNum : 3 , perPage : 10 ,startRow : 20
		this.startRow= this.getPerPage() * (this.getPageNum()-1);
		
	}
	
	public Integer getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10;
		}
		return this.perPage;
	}
	
	public Integer getPageNum() {
		if(this.pageNum==null || this.pageNum<1) {
			this.pageNum=1;
		}
		return this.pageNum;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return this.search;
	}
	

}
