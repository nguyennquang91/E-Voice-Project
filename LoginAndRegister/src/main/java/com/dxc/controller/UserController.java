package com.dxc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.model.User;
import com.dxc.model.UserLogin;
import com.dxc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServer;
	
	@RequestMapping(value = "/")
    public String homePage() {
        return "home";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        User user = new User();
        model.addObject("registeruser", user);
        model.setViewName("register");
        return model;
    }
	
	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
    public ModelAndView registerPage(@ModelAttribute User user) {
        if (user.getId() == 0) { // if invoice id is 0 then creating the
            // invoice other updating the invoice
            userServer.register(user);
        } 
        return new ModelAndView("registerSuccess");
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model){
		UserLogin userLogin = new UserLogin();
		model.addObject("userLogin", userLogin);
		model.setViewName("login");
		
		return model;
	}
		
	@RequestMapping(value="/loginSuccess",method = RequestMethod.POST)
	public ModelAndView processPage(@ModelAttribute User user, @Valid UserLogin userLogin) {
		int userExists = userServer.checkLogin(userLogin.getUserid(),userLogin.getPassword());
		if(userExists != 0){
			
			return new ModelAndView("welcome");
		}
		else{
			return new ModelAndView("error");
		}

	}
	
}
