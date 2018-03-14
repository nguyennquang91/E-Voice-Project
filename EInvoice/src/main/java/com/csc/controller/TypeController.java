package com.csc.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Invoice;
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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listType(ModelAndView model, Principal principal) throws IOException {
		String username = principal.getName();
		
		User user = userServer.getUserByName(username);
		int userId = user.getId();
		
    	List<Type> invoiceList = typeServer.getAllByUserId(userId);

    	model.addObject("typeList", invoiceList);
        model.setViewName("type");
        return model;
    }
	
	@RequestMapping(value = "/newType")
	public ModelAndView newType() {
		Type type = new Type();
		
		ModelAndView model = new ModelAndView("typeForm");
		model.addObject("type", type);
		return model;
	}
}