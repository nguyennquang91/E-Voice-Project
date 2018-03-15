package com.csc.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
import com.csc.model.User;
import com.csc.model.Invoice;
import com.csc.model.Year;
import com.csc.service.InvoiceService;
import com.csc.service.MonthService;
import com.csc.service.UserService;
import com.csc.service.YearService;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	UserService userServer;
	
	@Autowired
	InvoiceService invoiceServer;
	
	@Autowired
	MonthService monthServer;
	
	@Autowired
	YearService yearServer;
	
	@RequestMapping(value = "")
    public ModelAndView reportPage(Principal principal) {
		ModelAndView model = new ModelAndView("chart");
		model.addObject("yearSet", this.getYearSet(principal));
        return model;
    }
	
    @RequestMapping(value = "/getChart", method = RequestMethod.GET)
    public ModelAndView getReport(Principal principal, HttpServletRequest request) {
        int yearId = Integer.parseInt(request.getParameter("year_id"));
        Year selectedYear = yearServer.getYear(yearId);
        
        String username = principal.getName();
        User user = userServer.getUserByName(username);
		List<Invoice> invoiceList = invoiceServer.getAllByUserId(user.getId());
        
        List<Month> monthList = monthServer.getAll();
        
        Map<Integer, String> monthToMoneyMap = new LinkedHashMap<Integer, String>();
        for(Month m:monthList){
        	int moneyTotal = 0;
        	for(Invoice i:invoiceList){
        		if(i.getYear().getId() == yearId && i.getMonth().getId() == m.getId()){
        			moneyTotal += i.getMoney() + i.getVat();
        		}
        	}
        	monthToMoneyMap.put(m.getId(), "" + moneyTotal);
        }
        
        ModelAndView model = new ModelAndView("chart");
        model.addObject("selectedYearStr", selectedYear.getValue());
        model.addObject("yearSet", this.getYearSet(principal));
        model.addObject("monthToMoneyMap", monthToMoneyMap);
        
        return model;
    }
    
    private Set<Year> getYearSet(Principal principal){
    	String username = principal.getName();
		User user = userServer.getUserByName(username);
		List<Invoice> invoiceList = invoiceServer.getAllByUserId(user.getId());
		
		Set<Year> yearSet = new LinkedHashSet<Year>();
		
		for(Invoice i:invoiceList){
			yearSet.add(i.getYear());
		}
		
		return yearSet;
    }
}