package com.csc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.User;
import com.csc.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdmController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "")
    public ModelAndView listUser(ModelAndView model) throws IOException {
        ArrayList<User> userList = userService.getAll();
        model.addObject("userList", userList);
        model.addObject("stateMap", this.getUserStateMap());
        model.setViewName("admin");
        System.out.println(model);
        return model;
    }
	
	@RequestMapping(value="saveAllUser", method = RequestMethod.POST)
	 public ModelAndView saveAllUser(@ModelAttribute("userList") ArrayList<User> userList) {
		Iterator<User> itr = userList.iterator();
		while(itr.hasNext()){
			userService.updateUser(itr.next());
		}
		
        return new ModelAndView("redirect:/");
    }
	
	private Map<Integer,String> getUserStateMap(){
		Map<Integer,String> state = new HashMap<Integer,String>();
		state.put(0, "Deactivated");
		state.put(1, "Activated");
		
		return state;
    }
}
