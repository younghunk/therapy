package com.home;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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
//		 t.loadJsonData();
		 t.sendEmail();
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
	public void jsonFileWrite(HashMap<String,String> param) {
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
	public void sendEmail() {
		JavaMailSender mailSender = new JavaMailSenderImpl();
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hunkim5@naver.com");
        message.setFrom("help@apply.com");
        message.setSubject("제목2");
        message.setText("본문");

        mailSender.send(message);
	}
}
