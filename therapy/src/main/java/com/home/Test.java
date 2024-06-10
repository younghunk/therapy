package com.home;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("d:/test/one.txt"); //이어쓰기 false
		 int ch=0;
		 String txt = "";
		 while((ch = fr.read()) != -1) {
			 txt +=(char)ch;
		 }
		 System.out.println(txt);
	}

}
