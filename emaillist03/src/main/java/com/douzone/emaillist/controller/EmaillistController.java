package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	//1.주입 성공여부확인 //container의 기능적인 측면에서는 wired라고 함(DI관계인지 ask)
	@Autowired
	private EmaillistRepository emaillistRespository;
	
	//2.
	@RequestMapping("")
	public String index(Model model){
		List<EmaillistVo> list = emaillistRespository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}

}
