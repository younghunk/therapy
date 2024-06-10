package com.home.upload.dto;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable{
	
	private String fileName;
    private String folderPath;
    private String content;

    public String getImageURL() {
//        return URLEncoder.encode(folderPath+"/"+uuid+"_"+fileName, StandardCharsets.UTF_8);
        return URLEncoder.encode(fileName, StandardCharsets.UTF_8);
    }
    public String getThumbnailURL() {
//        return URLEncoder.encode(folderPath + "/s_" + uuid + "_" + fileName, StandardCharsets.UTF_8);
        return URLEncoder.encode(folderPath + "/s_" + fileName, StandardCharsets.UTF_8);
    }
}
