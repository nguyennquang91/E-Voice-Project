package com.csc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Type;
import com.csc.model.User;
import com.csc.service.TypeService;
import com.csc.service.UserService;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	TypeService typeServer;
	
	@Autowired
	UserService userServer;
	
	@RequestMapping(value = "/newType")
	public ModelAndView newType() {
		Type type = new Type();
		
		ModelAndView model = new ModelAndView("typeForm");
		model.addObject("type", type);
		return model;
	}
}