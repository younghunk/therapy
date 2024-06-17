package com.home.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Util {
	
	public static void fileMake(String fileName,String content,String path) {
		try(
				//true : 기존 파일에 이어서 작성 (default는 false임)
				FileWriter fw = new FileWriter(path+fileName,false); //이어쓰기 false
				BufferedWriter bw = new BufferedWriter(fw);
		) 
		{
			bw.write(content); //버퍼에 데이터 입력
            bw.flush(); //버퍼의 내용을 파일에 쓰기
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    public static String fileRead(String fileName,String path) {
    	String txt="";
		try(
				//true : 기존 파일에 이어서 작성 (default는 false임)
				FileReader fr = new FileReader(path+fileName); //이어쓰기 false
		) 
		{
			 int ch=0;
			 txt = "";
			 while((ch = fr.read()) != -1) {
				 txt +=(char)ch;
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return txt;
	}
}
