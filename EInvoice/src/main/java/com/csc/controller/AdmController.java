package com.csc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Invoice;
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
        for(User u: userList){
        	model.addObject("user_"+u.getUserId(), u);
        }
        model.addObject("stateMap", this.getUserStateMap());
        model.setViewName("admin");
        System.out.println(model);
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
	
	private Map<Integer,String> getUserStateMap(){
		Map<Integer,String> state = new HashMap<Integer,String>();
		state.put(0, "Deactivated");
		state.put(1, "Activated");
		
		return state;
    }
}
