package com.csc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.UserDTO;
import com.csc.service.UserService;

@Controller

public class IndexController {

	@Autowired
	UserService userServer;
	
	@RequestMapping("/create4test")
	public void index(){
		for (int i = 0; i < 100; i++) {
			UserDTO u = new UserDTO();
			u.setUsername("username"+i);
			u.setPassword("password"+i);
			userServer.saveOrUpdate(u);
		}
	}
	
	@RequestMapping("/register")
	public String createManual(){
		return "register";
	}
	
	@RequestMapping(value = "/showall", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public  ResponseEntity<ArrayList<UserDTO>> showAllUser(){
		return new ResponseEntity<ArrayList<UserDTO>>(userServer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/")
    public ModelAndView listUser(ModelAndView model) throws IOException {
        ArrayList<UserDTO> listUser = userServer.getAll();
        model.addObject("listUser", listUser);
        model.setViewName("home");
        return model;
    }
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        UserDTO user = new UserDTO();
        model.addObject("user", user);
        model.setViewName("UserForm");
        return model;
    }
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserDTO user) {
        if (user.getId() == 0) { // if user id is 0 then creating the
            // user other updating the user
            userServer.addUser(user);
        } else {
            userServer.updateUser(user);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userServer.deleteUser(userId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDTO user = userServer.getUser(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
 
        return model;
    }
}
