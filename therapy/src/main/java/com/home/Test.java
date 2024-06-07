package com.home;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				//true : 기존 파일에 이어서 작성 (default는 false임)
				FileWriter fw = new FileWriter("d:/tests/fileName.txt",true);
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
