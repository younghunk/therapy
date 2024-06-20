package com.home.upload.dto;

import java.io.Serializable;

public class RegDataDto implements Serializable{
	String siteName;
	String content1;
	String content2;
	String content3;
	String faq1;
	String faq2;
	String faq3;
	String faq4;
	String faq5;
	String faq6;
	String faqaw1;
	String faqaw2;
	String faqaw3;
	String faqaw4;
	String faqaw5;
	String faqaw6;
	String hp;
	String kakao;
	String line;
	String telegram;
	String uploadFiles;
	
	public String getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(String uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public String getFaq1() {
		return faq1;
	}
	public void setFaq1(String faq1) {
		this.faq1 = faq1;
	}
	public String getFaq2() {
		return faq2;
	}
	public void setFaq2(String faq2) {
		this.faq2 = faq2;
	}
	public String getFaq3() {
		return faq3;
	}
	public void setFaq3(String faq3) {
		this.faq3 = faq3;
	}
	public String getFaq4() {
		return faq4;
	}
	public void setFaq4(String faq4) {
		this.faq4 = faq4;
	}
	public String getFaq5() {
		return faq5;
	}
	public void setFaq5(String faq5) {
		this.faq5 = faq5;
	}
	public String getFaq6() {
		return faq6;
	}
	public void setFaq6(String faq6) {
		this.faq6 = faq6;
	}
	public String getFaqaw1() {
		return faqaw1;
	}
	public void setFaqaw1(String faqaw1) {
		this.faqaw1 = faqaw1;
	}
	public String getFaqaw2() {
		return faqaw2;
	}
	public void setFaqaw2(String faqaw2) {
		this.faqaw2 = faqaw2;
	}
	public String getFaqaw3() {
		return faqaw3;
	}
	public void setFaqaw3(String faqaw3) {
		this.faqaw3 = faqaw3;
	}
	public String getFaqaw4() {
		return faqaw4;
	}
	public void setFaqaw4(String faqaw4) {
		this.faqaw4 = faqaw4;
	}
	public String getFaqaw5() {
		return faqaw5;
	}
	public void setFaqaw5(String faqaw5) {
		this.faqaw5 = faqaw5;
	}
	public String getFaqaw6() {
		return faqaw6;
	}
	public void setFaqaw6(String faqaw6) {
		this.faqaw6 = faqaw6;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getKakao() {
		return kakao;
	}
	public void setKakao(String kakao) {
		this.kakao = kakao;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getTelegram() {
		return telegram;
	}
	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}
	@Override
    public String toString() {
        return "RegDataDto{" +
        		"siteName:"+siteName+'\'' +   
		        "content1:"+content1+ '\'' +  
		        "content2:"+   content2+ '\'' +  
		        "content3:"+   content3 +'\'' +  
		        "faq1    :"+   faq1     +'\'' +  
		        "faq2    :"+   faq2     +'\'' +  
		        "faq3    :"+   faq3     +'\'' + 
		        "faq4    :"+   faq4     +'\'' +  
		        "faq5    :"+   faq5     +'\'' +  
		        "faq6    :"+   faq6     +'\'' +  
		        "faqaw1  :"+   faqaw1   +'\'' +  
		        "faqaw2  :"+   faqaw2   +'\'' +  
		        "faqaw3  :"+   faqaw3   +'\'' +  
		        "faqaw4  :"+   faqaw4   +'\'' +  
		        "faqaw5  :"+   faqaw5   +'\'' +  
		        "faqaw6  :"+   faqaw6   +'\'' +  
		        "hp      :"+   hp       +'\'' +  
		        "kakao   :"+   kakao    +'\'' +  
		        "line    :"+   line     +'\'' +  
		        "telegram:"+   telegram +'\'' +  
                '}';
    }
}
