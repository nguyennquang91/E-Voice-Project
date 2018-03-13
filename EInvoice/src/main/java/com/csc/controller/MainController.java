package com.csc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.model.Month;
import com.csc.model.Type;
import com.csc.model.User;
import com.csc.model.UserRole;
import com.csc.model.Year;
import com.csc.service.MonthService;
import com.csc.service.TypeService;
import com.csc.service.UserRoleService;
import com.csc.service.UserService;
import com.csc.service.YearService;

@Controller
public class MainController {
	@Autowired
	UserRoleService userRoleServer;
	
	@Autowired
	MonthService monthServer;

	@Autowired
	YearService yearServer;

	@Autowired
	TypeService typeServer;

	@Autowired
	UserService userServer;
	
   @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
   public String loginPage(ModelAndView model) {
       return "loginPage";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(ModelAndView model) {
       return "redirect:/";
   }
   
   @RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model){
		User user = new User();
		model.addObject("user", user);
		model.setViewName("registrationForm");
		return model;
	}	
   
   @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
   public ModelAndView saveUser(@ModelAttribute User user) {
       if (user.getId() == 0) {
    	   String username = user.getUsername();
    	   
          if(userServer.getUserByName(username) == null){
          		UserRole userRole = new UserRole();
          		userRole.setUsername(username);
          		userRole.setRole("ROLE_USER");
          		userRoleServer.addUserRole(userRole);
          		
          		user.setRole(userRole);
          		user.setEnabled(1);
          		userServer.addUser(user);
          		
          		return new ModelAndView("redirect:/");
          	}
       }
       ModelAndView model = new ModelAndView();
       String message = "This username already exists!!";
       model.addObject("message", message);
       model.setViewName("registrationForm");
       return model;
       
   }
   
   @RequestMapping(value = "/processUser", method = RequestMethod.GET)
   public String processLogin(Principal principal){
	   String name = principal.getName();
	   
	   UserRole userRole = userRoleServer.getUserRoleByName(name);
	   
	   if(userRole.getRole().equals("ROLE_ADMIN")){
		   return "redirect:/admin";
	   }
	   return "redirect:/invoice";
   }
   
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public ModelAndView accessDenied(ModelAndView model, Principal principal) {
        
       if (principal != null) {
           model.addObject("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addObject("message",
                   "You do not have permission to access this page!");
       }
       
       model.setViewName("403Page");
       return model;
   }
   
   @RequestMapping(value = "/create4test")
   public String create4test(){
	   String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", 
			   "September", "October", "November", "December"};
	   for(String m:monthList){
		   Month month = new Month();
		   month.setName(m);
		   monthServer.addMonth(month);
	   }
	   
	  for(int i = 0; i < 41; i++){
		  Year year = new Year();
		  year.setValue(1990+i);
		  yearServer.addYear(year);
	  }

	  String[] typeList = {"Electric", "Water", "Telephone", "Internet"};
	  for(int i = 0; i < 7; i++){
		  UserRole role = new UserRole();
		  role.setUsername("user" + (i + 1));
		  role.setRole("ROLE_USER");
		  
		  User user = new User();
		  user.setUsername("user" + (i+1));
		  user.setPassword("upass" + (i+1));
		  user.setEmail("uemail" + (i+1));
		  user.setEnabled(1);
		  user.setRole(role);
		  
		  userRoleServer.addUserRole(role);
		  userServer.addUser(user);
		  
		  for(String t: typeList){
			  Type type = new Type();
			  type.setName(t);
			  type.setUser(user);
			  typeServer.addType(type);
		  }
	  }
	  
	  for(int i = 0; i < 3; i++){
		  UserRole role = new UserRole();
		  role.setUsername("admin" + (i + 1));
		  role.setRole("ROLE_ADMIN");
		  
		  User user = new User();
		  user.setUsername("admin" + (i+1));
		  user.setPassword("apass" + (i+1));
		  user.setEmail("aemail" + (i+1));
		  user.setEnabled(1);
		  user.setRole(role);
		  
		  userRoleServer.addUserRole(role);
		  userServer.addUser(user);
	  }
	   return "redirect:/";
   }
}