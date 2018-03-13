package com.csc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.User;
import com.csc.model.UserRole;
import com.csc.service.UserRoleService;
import com.csc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userServer;
	
	@Autowired
	UserRoleService userRoleServer;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        if (user.getId() != 0) {
        	userServer.updateUser(user);
            return "redirect:/invoice";
        }
        else{
        	String username = user.getUsername();
        	User userToCheck = userServer.getUserByName(username);
        	if(null != userToCheck){
        		UserRole userRole = new UserRole();
        		userRole.setUsername(username);
        		userRole.setRole("ROLE_USER");
        		userRoleServer.addUserRole(userRole);
        		
        		user.setRole(userRole);
        		user.setEnabled(1);
        		userServer.addUser(user);
        		
        		return "redirect:/";
        	}
        	else{
        		return "redirect:/user/newUser";
        	}
        }
    }
	
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editInvoice(Principal principal) {
    	String username = principal.getName();
    	User user = userServer.getUserByName(username);
        ModelAndView model = new ModelAndView("userForm");
        model.addObject("user", user);
        return model;
    }
}