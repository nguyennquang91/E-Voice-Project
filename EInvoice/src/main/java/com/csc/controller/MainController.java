package com.csc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
   @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
   public String welcomePage(ModelAndView model) {
       return "loginPage";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(ModelAndView model) {
       return "redirect:/";
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
}