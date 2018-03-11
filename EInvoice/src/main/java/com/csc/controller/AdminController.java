package com.csc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.User;
import com.csc.model.UserListWrapper;
import com.csc.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listUser(ModelAndView model) throws IOException {
        List<User> userList = userService.getAll();
        
        UserListWrapper userListWrapper = new UserListWrapper();
        userListWrapper.setUserList(userList);
        
        model.addObject("userListWrapper", userListWrapper);
        model.addObject("stateMap", this.getUserStateMap());
        model.setViewName("admin");
        return model;
    }
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        if (user.getUserId() != 0) {
            userService.updateUser(user);
        }
        System.out.println("triggered");
        return new ModelAndView("redirect:/admin");
    }
	
	@RequestMapping(value = "/saveAllUser", method = RequestMethod.POST)
	public ModelAndView saveAllUser(@ModelAttribute UserListWrapper userListWrapper){
		List<User> userList = userListWrapper.getUserList();
		
		for(User u:userList){
			if (u.getUserId() != 0) {
	            userService.updateUser(u);
	        }
		}
        return new ModelAndView("redirect:/admin");
	}
	
	private Map<Integer,String> getUserStateMap(){
		Map<Integer,String> state = new HashMap<Integer,String>();
		state.put(0, "Deactivated");
		state.put(1, "Activated");
		
		return state;
    }
}
