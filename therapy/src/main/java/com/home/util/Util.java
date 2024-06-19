package com.home.util;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.TestJsonDto;
import com.home.upload.dto.RegDataDto;

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
    public static void jsonFileWrite(HashMap<String,String> param) {
		// JSON 객체 생성
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("key1", "value1");
//        jsonObject.put("key2", "value2");
        for( Map.Entry<String, String> entry : param.entrySet() ){
        	String strKey = entry.getKey();
        	String strValue = entry.getValue();
        	jsonObject.put(strKey, strValue);
        }
        
        // 파일에 JSON 객체 쓰기
        try (FileWriter file = new FileWriter("src/main/resources/output.json")) {
            file.write(jsonObject.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    public static RegDataDto loadJsonData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream jsonFile1 = new ClassPathResource("output.json").getInputStream();
        RegDataDto tjdto = objectMapper.readValue(jsonFile1, RegDataDto.class);
          
        return tjdto;
    }
}
