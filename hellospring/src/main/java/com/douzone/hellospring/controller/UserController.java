package com.douzone.hellospring.controller;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping url + request method 매핑
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET) // 2개 이상일때는 값에 이름을 줘야한다 1개일떄는 디폴트로 지정됨
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST) // 2개 이상일때는 값에 이름을 줘야한다 1개일떄는 디폴트로 지정됨
	public String join(UserVo vo) throws UnsupportedEncodingException {

		System.out.println(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n")String name) {
		//만일 n이라는 파라미터가 없는 경우
		//400 bad request가 발생한다.
		System.out.println();
		return"UserController.update("+ name +")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n", required = true, defaultValue = "yuin")String name,
			@RequestParam(value="a", required = true, defaultValue = "25")int age){
		System.out.println();
		return"UserController.update("+ name +":"+ age +")";
	}

}









