package com.home;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("d:/test/one.txt"); //이어쓰기 false
		 int ch=0;
		 String txt = "";
		 while((ch = fr.read()) != -1) {
			 txt +=(char)ch;
		 }
		 System.out.println(txt);
		 Test t= new Test();
		 //t.jsonFileWrite();
		 t.loadJsonData();
	}
	
	public void loadJsonData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream jsonFile1 = new ClassPathResource("output.json").getInputStream();
//        System.out.println(jsonFile.exists());
        TestJsonDto tjdto = objectMapper.readValue(jsonFile1, TestJsonDto.class);
        System.out.println(">>>dto:"+tjdto.getKey1());
        
//        File jsonFile = new ClassPathResource("output.json").getFile();
//        FileReader fr = new FileReader(jsonFile);
//        int ch;
//        String jsonData="";
//        while ((ch = fr.read()) != -1) {
//        	jsonData += (char) ch;
//        }
//        JSONObject jsonObject = new JSONObject(jsonData);
//        System.out.println(">>>jsonObject:"+jsonObject.getString("key1"));
        //return objectMapper.readValue(jsonFile, TestJsonDto.class);
    }
	public void jsonFileWrite() {
		// JSON 객체 생성
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");
        
        // 파일에 JSON 객체 쓰기
        try (FileWriter file = new FileWriter("src/main/resources/output.json")) {
            file.write(jsonObject.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
