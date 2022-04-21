package com.sj.boot3.board;

import com.sj.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BoardFilesVO extends FileVO{
	
	private Long num;

}
