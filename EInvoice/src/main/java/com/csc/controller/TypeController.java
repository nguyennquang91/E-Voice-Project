package com.csc.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Invoice;
import com.csc.model.Type;
import com.csc.model.User;
import com.csc.service.TypeService;
import com.csc.service.UserService;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	TypeService typeServer;
	
	@Autowired
	UserService userServer;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listType(ModelAndView model, Principal principal) throws IOException {
		String username = principal.getName();
		
		User user = userServer.getUserByName(username);
		int userId = user.getId();
		
    	List<Type> typeList = typeServer.getAllByUserId(userId);

    	model.addObject("typeList", typeList);
        model.setViewName("type");
        return model;
    }

	@RequestMapping(value = "/newType", method = RequestMethod.GET)
    public ModelAndView newType(ModelAndView model, Principal principal) {
		String username = principal.getName();
		User user = userServer.getUserByName(username);
        Type type = new Type();
        type.setUser(user);
        model.addObject("type", type);
        model.setViewName("typeForm");
        return model;
    }
	
    @RequestMapping(value = "/editType", method = RequestMethod.GET)
    public ModelAndView editType(HttpServletRequest request) {
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        Type type = typeServer.getType(typeId);
        
        ModelAndView model = new ModelAndView("typeForm");
        model.addObject("type", type);
        
        return model;
    }
    
    @RequestMapping(value = "/deleteType", method = RequestMethod.GET)
    public String deleteType(HttpServletRequest request) {
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        typeServer.deleteType(typeId);
        
        return "redirect:/type";
    }
 
	@RequestMapping(value = "/saveType", method = RequestMethod.POST)
    public ModelAndView saveType(@ModelAttribute Type type, Principal principal) {
		if(validate(type, principal)){
			if (type.getId() != 0) {
	        	typeServer.updateType(type);
	        }
	        else{
	        	typeServer.addType(type);
	        }
	        return new ModelAndView ("redirect:/type");
		}
        ModelAndView model = new ModelAndView("typeForm");
        model.addObject("message", "This invoice type already exists!!");
        model.addObject("type", type);
        return model;
    }
	
	private boolean validate(Type type, Principal principal) {
		String username = principal.getName();
		
		User user = userServer.getUserByName(username);
		int userId = user.getId();
		
    	List<Type> typeList = typeServer.getAllByUserId(userId);
    	
    	if(type.getId() != 0){
        	int typeToRemove = -1;
    		for(Type t:typeList){
    			if(t.getId() == type.getId()){
    				typeToRemove = typeList.indexOf(t);
    			}
    		}
    		if(typeToRemove != -1){
    			typeList.remove(typeToRemove);
    		}
    	}
    	
    	for(Type t:typeList){
    		if(t.getName().equalsIgnoreCase(type.getName())){
    			return false;
    		}
    	}
		return true;
	}
}