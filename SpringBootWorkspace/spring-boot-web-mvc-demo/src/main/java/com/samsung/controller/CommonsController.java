package com.samsung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/commons")
public class CommonsController {
	
	@RequestMapping("/header")
	public String headerAction() {
		return "commons/header-segment";
	}

	@RequestMapping(value="/contactUs",method=RequestMethod.GET)
	public ModelAndView contactUsAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("commons/contact-us-page");
		mv.addObject("mobile", "9897238030");
		mv.addObject("mail", "utkarsh.b1358@gmail.com");
		
		return mv;
	}
}
