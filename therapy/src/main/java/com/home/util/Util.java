package com.home.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Util {
	
	public void fileMake(String fileName,String content) {
		try(
				//true : 기존 파일에 이어서 작성 (default는 false임)
				FileWriter fw = new FileWriter("d:/test/fileName.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
		) 
		{
			bw.write("손흥민"); //버퍼에 데이터 입력
            bw.flush(); //버퍼의 내용을 파일에 쓰기
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
