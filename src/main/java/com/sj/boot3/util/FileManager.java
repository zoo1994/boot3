package com.sj.boot3.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public String fileSave(MultipartFile mf, String path)throws Exception{
		//path = 프로젝트상의 파일을 저장할 폴더경로
		//1. 파일을 hdd에 저장
		//2. 저장된 파일명을 리턴(파일명 중복x)
		path= servletContext.getRealPath(path);
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString();
		fileName=fileName+"_"+mf.getOriginalFilename();
		
		file = new File(file,fileName);
		mf.transferTo(file);
		return fileName;
	}
	
	public boolean remove(String path,String fileName)throws Exception{
		path = servletContext.getRealPath(path);
		File file = new File(path,fileName);
		return file.delete();
	}
	
}
