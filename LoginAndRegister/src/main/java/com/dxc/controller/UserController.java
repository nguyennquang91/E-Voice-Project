package com.dxc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.model.User;
import com.dxc.model.Login;
import com.dxc.service.AdminService;
import com.dxc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServer;
	
	@Autowired
	private AdminService adminServer;

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
		Login login = new Login();
		model.addObject("userLogin", login);
		model.setViewName("login");
		
		return model;
	}
	
	@RequestMapping(value="/loginUser", method = RequestMethod.POST)
	public ModelAndView processPageUser(@ModelAttribute @Valid Login loginUser,@Valid Login loginAdmin) {
		int userExists = userServer.checkLoginUser(loginUser.getId(),loginUser.getPassword());
		int adminExists = adminServer.checkLoginAdmin(loginAdmin.getId(), loginAdmin.getPassword());
		
		if(userExists != 0)
			return new ModelAndView("welcome");
		else if(adminExists != 0)
			return new ModelAndView("admin");
		else
			return new ModelAndView("error");
		
	}	
	

	
		
}
