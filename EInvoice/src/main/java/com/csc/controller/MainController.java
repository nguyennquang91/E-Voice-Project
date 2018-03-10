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
 
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
   public String adminPage(ModelAndView model) {
       return "adminPage";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(ModelAndView model) {
       return "redirect:/";
   }
 
   @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
   public String userInfo(ModelAndView model, Principal principal) {
 
       String userName = principal.getName();
 
       System.out.println("User Name: "+ userName);
 
       return "userInfoPage";
   }
 
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(ModelAndView model, Principal principal) {
        
       if (principal != null) {
           model.addObject("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addObject("message",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }
}