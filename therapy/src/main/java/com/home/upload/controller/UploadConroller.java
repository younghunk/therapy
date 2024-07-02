package com.home.upload.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.home.upload.dto.UploadResultDTO;
import com.home.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UploadConroller {
	
	
	
	/*파일 업로드, 업로드 결과 반환*/
    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles,@RequestParam HashMap<String,String> param,HttpServletRequest req) throws IOException {
    	String uploadPath = new File("").getAbsolutePath() +"/src/main/resources/static/";
    	String content= param.get("content1");
    	log.info(">>>>>>>>>>>Start>>>>>>>>>>>"+param);
    	Util.fileMake("one.txt",content,uploadPath);
    	
    	//json file write
    	Util.jsonFileWrite(param);
    	
        List<UploadResultDTO> resultDTOList = new ArrayList<>();
        String fileName="";
        String folderPath="";
        log.info(">>>>uploadFiles:"+uploadFiles);
        if(uploadFiles != null) {
        	int cnt=1;
	        for (MultipartFile uploadFile: uploadFiles) {
	        	 
	            // 이미지 파일만 업로드
	            if (!Objects.requireNonNull(uploadFile.getContentType()).startsWith("image")) {
	                log.warn("this file is not image type");
	                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	            }
	
	            // 실제 파일 이름 IE나 Edge는 전체 경로가 들어오므로 => 바뀐 듯 ..
	            String orginalName = uploadFile.getOriginalFilename();
	            log.info(">>orginalName:"+orginalName);
	            assert orginalName != null;
	//            String fileName = orginalName.substring(orginalName.lastIndexOf("\\") + 1);
	            String ext = orginalName.substring(orginalName.lastIndexOf(".") + 1);//확장자
	            fileName = cnt+"."+ext; cnt++;
	            	
	            log.info("fileName1: "+fileName);
	            log.info("fileName2: "+fileName.substring(fileName.lastIndexOf(".") + 1));
	            log.info("fileName3: "+fileName.substring(0,fileName.lastIndexOf(".")));
	
	            // 날짜 폴더 생성
	            //folderPath = makeFolder();
	
	            // UUID
	            String uuid = UUID.randomUUID().toString();
	
	            // 저장할 파일 이름 중간에 "_"를 이용해서 구현
	//            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
	            //String saveName = uploadPath + File.separator + fileName;
	            String saveName = new File("").getAbsolutePath() +"/src/main/resources/static/"+ fileName;
	            log.info(">>>saveName:"+saveName);
	            Path savePath = Paths.get(saveName);
	            log.info(">>>>savePath:"+savePath.toString());
	            try {
	                uploadFile.transferTo(savePath); // 실제 이미지 저장
	                
	                // 섬네일 생성
	                String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid + "_" + fileName;	
	                // 섬네일 생성
	//                File thumbnailFile = new File(thumbnailSaveName);
	//                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);	                
	                resultDTOList.add(new UploadResultDTO(fileName, folderPath,content));
	
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	
	        }
        }
        resultDTOList.add(new UploadResultDTO(fileName, folderPath,content));
        
        Util.restartServer(req);
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }
    
    
    /*날짜 폴더 생성*/
//    private String makeFolder() {
//
//        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//
//        String folderPath = str.replace("/", File.separator);
//
//        // make folder --------
//        File uploadPathFolder = new File(uploadPath, folderPath);
//
//        if(!uploadPathFolder.exists()) {
//            boolean mkdirs = uploadPathFolder.mkdirs();
//            log.info("-------------------makeFolder------------------");
//            log.info("uploadPathFolder.exists(): "+uploadPathFolder.exists());
//            log.info("mkdirs: "+mkdirs);
//        }
//
//        return folderPath;
//
//    }
    
    /*업로드 이미지 출력하기*/
    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {

        ResponseEntity<byte[]> result;

        try {
            String srcFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

            log.info("fileName: " + srcFileName);
            	
            String filePath = new File("").getAbsolutePath() +"/src/main/resources/static/";
            
            File file = new File(filePath + srcFileName);

            log.info("file: " + file);

            HttpHeaders header = new HttpHeaders();


            // MIME 타입 처리
            header.add("Content-Type", Files.probeContentType(file.toPath()));

            // 파일 데이터 처리
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);


        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;

    }
    
}
