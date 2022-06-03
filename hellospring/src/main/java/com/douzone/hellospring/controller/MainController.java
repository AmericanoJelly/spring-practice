package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	

	@ResponseBody
	@RequestMapping({"","/main","/main/a/b/c/d"}) //여러개로 url 매핑이 가능하다
	public String main() {
		return "MainController.main()";
	}
}
