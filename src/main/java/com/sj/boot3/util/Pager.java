package com.sj.boot3.util;

import lombok.Data;

@Data
public class Pager {
	private String id;
	//db에서 몇개씩 조회
	private Integer perPage;
	//page 번호(파라미터 값)
	private Integer pageNum;
	//DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	private Integer startPageNum;
	private Integer lastPageNum;
	private boolean next;
	private boolean pre;
	private String search;
	private Integer kind;
	
	public void makeRow() {
		//pageNum : 1 , perPage : 10 ,startRow : 0 
		//pageNum : 2 , perPage : 10 ,startRow : 10
		//pageNum : 3 , perPage : 10 ,startRow : 20
		this.startRow= this.getPerPage() * (this.getPageNum()-1);
		
	}
	
	public void makePage(Integer total) {
		//전체 페이지 구하기
		Integer totalPage = total/this.getPerPage();
		if(total%this.getPerPage()>0) {
			totalPage++;
		}
		//블럭당 보여줄 페이지갯수
		Integer pageBlock = 10;
		//총 블럭갯수
		Integer totalBlock = totalPage/pageBlock;
		if(totalPage%pageBlock>0) {
			totalBlock++;
		}
		//현재 페이지로 현재 블락구하기
		Integer curBlock = this.getPageNum()/pageBlock;
		if(this.getPageNum()%pageBlock>0) {
			curBlock++;
		}
		//block에서 시작페이지번호 끝페이지번호 구하기
		this.startPageNum= (curBlock-1)*pageBlock+1;
		this.lastPageNum= curBlock*pageBlock;
		//이전 이후 존재여부
		this.pre = false;
		if(curBlock>1) {
			this.pre=true;
		}
		this.next=false;
		if(curBlock<totalBlock) {
			this.next=true;
		}
		//현재블럭이 마지막블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastPageNum=totalPage;
		}
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
