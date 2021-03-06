package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	// value="" 비우는건 GET일때만 가능

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String index(GuestBookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no) {
		return "/WEB-INF/views/delete.jsp";
	}


	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String delete(
		@PathVariable("no") Long no,
		@RequestParam(value = "password", required = true, defaultValue = "") String password) {
	guestbookRepository.delete(no, password);
		return "redirect:/";
	}
	
	/* vo로 받아오기
	 * @RequestMapping(value = "/delete/{no}", method = RequestMethod.POST) public
	 * String delete(@PathVariable("no") Long no, GuestBookVo vo) {
	 * guestbookRepository.delete(vo); return "redirect:/"; }
	 */
	
	/* vo로 객체 생성해서 받아오기
	 * @RequestMapping(value="/delete/{no}", method=RequestMethod.POST) public
	 * String delete(@PathVariable("no") Long no,
	 * 
	 * @RequestParam(value="password", required=true, defaultValue="") String
	 * password) { 
	 * GuestBookVo vo = new GuestBookVo(); 
	 * vo.setNo(no);
	 * vo.setPassword(password);
	 * 
	 * guestbookRepository.delete(vo); return "redirect:/";
	 *  }
	 */
	 
}
