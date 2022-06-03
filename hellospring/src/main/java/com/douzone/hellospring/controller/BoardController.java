package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 *@RequestMapping Method 단독 매핑
 *
 */
@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";	
	}
	
	@ResponseBody
	@RequestMapping("/board/writeform")
	public String writeform() {
		return "BoardController.writeform()";
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable("no") int no) { 
		//@PathVariable("no") path의 변수 이름
		//주소: http://localhost:8080/hellospring/board/view/10
		//결과: BoardController.view(10)
		return "BoardController.view("+ no +")";	
	}
	

}
