package com.ojt.crud.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("text","Hello Spring MVC");
		return(mv);
	}
}
