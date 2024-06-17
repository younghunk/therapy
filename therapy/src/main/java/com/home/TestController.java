package com.home;

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

import com.home.upload.controller.UploadConroller;
import com.home.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
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
	@GetMapping("/view")
    public String viewData(@RequestParam Map<String, Object> params,Model model) {
    	log.info(">>>params:"+params);
        List<HashMap<String,Object>> resultList = new ArrayList<>();
        String txtOne = Util.fileRead("one.txt");
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
	@GetMapping("/index")
	public String index() {
		
		return "/index";
	}
}
