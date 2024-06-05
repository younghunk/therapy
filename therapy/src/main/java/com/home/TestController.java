package com.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	@Value("${upload.path}")
	private String uploadPath;
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String goHome(HttpServletRequest request) {
		System.out.println(">>>>>>>>>>uploadPath:"+uploadPath);
		return "content/home";
	}
	
	@GetMapping("/uploadEx")
	public String uploadEx() {
		
		return "content/uploadEx";
	}
}
