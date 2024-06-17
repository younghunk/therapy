package com.home;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;

@Controller
@Log4j2
public class TestController {

	@Value("${upload.path}")
	private String uploadPath;
	
	@Value("classpath:/")
	Resource resourceFile;
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String goHome(HttpServletRequest request) throws IOException {
		System.out.println(">>>>>>>>>>uploadPath:"+uploadPath);
		System.out.println(">>>>>>>>>>uploadPath:"+resourceFile.getURI().toString());
		System.out.println(">>>>>>>>>>uploadPath:"+resourceFile.getURL().toString());
		return "content/home";
	}
	
	@GetMapping("/uploadEx")
	public String uploadEx() {
		
		return "content/uploadEx";
	}
	@GetMapping("/view")
    public String viewData(@RequestParam Map<String, Object> params,Model model) {
    	log.info(">>>params:"+params);
    	String uploadPath = new File("").getAbsolutePath() +"/src/main/resources/static/";
        List<HashMap<String,Object>> resultList = new ArrayList<>();
        String txtOne = Util.fileRead("one.txt",uploadPath);
        log.info(">>>txtOne:"+txtOne);
        HashMap<String,Object> data = new HashMap<>();
        data.put("txtOne", txtOne);
        resultList.add(data);
        String nlString = System.getProperty("line.separator").toString();
        model.addAttribute("resultList", resultList);
        model.addAttribute("nlString", nlString);
        
        
        return "content/view";
    }
	@GetMapping("/detail_reg")
	public String detail_reg() {
		
		return "/detail_reg";
	}
	@GetMapping("/index1")
	public String index(@RequestParam Map<String, Object> params,Model model) {
		String uploadPath = new File("").getAbsolutePath() +"/src/main/resources/static/";
        HashMap<String,Object> content1 = new HashMap<String,Object>();
        String txtOne = Util.fileRead("one.txt",uploadPath);
        log.info(">>content:"+txtOne);
        content1.put("txtOne", txtOne);
        String nlString = System.getProperty("line.separator").toString();
        model.addAttribute("content1", content1);
        model.addAttribute("nlString", nlString);
		return "/index";
	}
}
