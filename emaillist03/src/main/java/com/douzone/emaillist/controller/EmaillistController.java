package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@ResponseBody
	@RequestMapping("")
	public String index(){
		List<EmaillistVo> list =new EmaillistRepository().findAll();
		model.addAttribute();
		return "/WEB-INF/views/index.jsp";
	}

}
