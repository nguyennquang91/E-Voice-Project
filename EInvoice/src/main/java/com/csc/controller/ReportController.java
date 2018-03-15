package com.csc.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Month;
import com.csc.model.Type;
import com.csc.model.User;
import com.csc.model.Invoice;
import com.csc.model.Year;
import com.csc.service.InvoiceService;
import com.csc.service.MonthService;
import com.csc.service.TypeService;
import com.csc.service.UserService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	UserService userServer;
	
	@Autowired
	InvoiceService invoiceServer;
	
	@Autowired
	TypeService typeServer;
	
	@Autowired
	MonthService monthServer;
	
	@RequestMapping(value = "")
    public ModelAndView reportPage(Principal principal) {
		ModelAndView model = new ModelAndView("report");
		model.addObject("yearSet", this.getYearSet(principal));
        return model;
    }
	
    @RequestMapping(value = "/getReport", method = RequestMethod.GET)
    public ModelAndView getReport(Principal principal, HttpServletRequest request) {
        int yearId = Integer.parseInt(request.getParameter("year_id"));
        
        String username = principal.getName();
        User user = userServer.getUserByName(username);
		List<Invoice> invoiceList = invoiceServer.getAllByUserId(user.getId());
		
        List<Type> typeList = typeServer.getAllByUserId(user.getId());
        
        List<Month> monthList = monthServer.getAll();
        
        Map<String, String> typeToMoneyMap = new LinkedHashMap<String, String>();
        for(Type t:typeList){
        	int moneyTotal = 0;
        	for(Invoice i:invoiceList){
        		if(i.getYear().getId() == yearId && i.getType().getId() == t.getId()){
        			moneyTotal += i.getMoney();
        		}
        	}
        	typeToMoneyMap.put(t.getName(), "" + moneyTotal);
        }
        
        Map<String, String> monthToMoneyMap = new LinkedHashMap<String, String>();
        for(Month m:monthList){
        	int moneyTotal = 0;
        	for(Invoice i:invoiceList){
        		if(i.getYear().getId() == yearId && i.getMonth().getId() == m.getId()){
        			moneyTotal += i.getMoney();
        		}
        	}
        	monthToMoneyMap.put(m.getName(), "" + moneyTotal);
        }
        
        ModelAndView model = new ModelAndView("report");
        model.addObject("yearSet", this.getYearSet(principal));
        model.addObject("typeToMoneyMap", typeToMoneyMap);
        model.addObject("monthToMoneyMap", monthToMoneyMap);
        
        return model;
    }
    
    private Set<Year> getYearSet(Principal principal){
    	String username = principal.getName();
		User user = userServer.getUserByName(username);
		List<Invoice> invoiceList = invoiceServer.getAllByUserId(user.getId());
		
		Set<Year> yearSet = new HashSet<Year>();
		
		for(Invoice i:invoiceList){
			yearSet.add(i.getYear());
		}
		
		return yearSet;
    }
}