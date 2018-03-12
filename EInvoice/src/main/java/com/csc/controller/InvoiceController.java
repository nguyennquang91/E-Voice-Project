package com.csc.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.model.Invoice;
import com.csc.model.User;
import com.csc.service.InvoiceService;
import com.csc.service.UserService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceServer;
	
	@Autowired
	UserService userServer;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listInvoice(ModelAndView model, Principal principal) throws IOException {
		String username = principal.getName();
		
		User user = userServer.getUserByName(username);
		int userId = user.getId();
		
    	List<Invoice> invoiceList = invoiceServer.getAllByUserId(userId);

    	model.addObject("listInvoice", invoiceList);
    	
		List<String> monthList = new ArrayList<String>();
		for (Map.Entry<Integer, String> entry : this.getMonthMap().entrySet())
		{
		    monthList.add(entry.getValue());
		}
		
		List<String> typeList = new ArrayList<String>();
		for (Map.Entry<Integer, String> entry : this.getTypeMap().entrySet())
		{
		    typeList.add(entry.getValue());
		}
		
		List<String> yearList = new ArrayList<String>();
		for (Map.Entry<Integer, String> entry : this.getYearMap().entrySet())
		{
		    yearList.add(entry.getValue());
		}
		model.addObject("typeList", typeList);
		model.addObject("monthList", monthList);
		model.addObject("yearList", yearList);
        model.setViewName("invoice");
        return model;
    }
	
	@RequestMapping(value = "/newInvoice", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Invoice invoice = new Invoice();
        model.addObject("invoice", invoice);
		model.addObject("monthList", this.getMonthMap());
		model.addObject("typeList", this.getTypeMap());
		model.addObject("yearList", this.getYearMap());
        model.setViewName("InvoiceForm");
        return model;
    }
	
	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    public ModelAndView saveInvoice(@ModelAttribute Invoice invoice, Principal principal) {
        if (invoice.getId() != 0) {
        	invoiceServer.updateInvoice(invoice);
        }
        else{
        	String username = principal.getName();
        	User user = userServer.getUserByName(username);
        	
        	invoice.setUserId(user.getId());
        	invoiceServer.addInvoice(invoice);
        }
        return new ModelAndView("redirect:/invoice");
    }
 
    @RequestMapping(value = "/deleteInvoice", method = RequestMethod.GET)
    public ModelAndView deleteInvoice(HttpServletRequest request) {
        int invoiceId = Integer.parseInt(request.getParameter("invoice_id"));
        invoiceServer.deleteInvoice(invoiceId);
        return new ModelAndView("redirect:/invoice");
    }
 
    @RequestMapping(value = "/editInvoice", method = RequestMethod.GET)
    public ModelAndView editInvoice(HttpServletRequest request) {
        int invoiceId = Integer.parseInt(request.getParameter("invoice_id"));
        Invoice invoice = invoiceServer.getInvoice(invoiceId);
        ModelAndView model = new ModelAndView("InvoiceForm");
        model.addObject("invoice", invoice);
		model.addObject("monthList", this.getMonthMap());
		model.addObject("typeList", this.getTypeMap());
		model.addObject("yearList", this.getYearMap());
        return model;
    }
    
    private Map<Integer,String> getMonthMap(){
		Map<Integer,String> month = new HashMap<Integer,String>();
		month.put(1, "January");
		month.put(2, "February");
		month.put(3, "March");
		month.put(4, "April");
		month.put(5, "May");
		month.put(6, "June");
		month.put(7, "July");
		month.put(8, "August");
		month.put(9, "September");
		month.put(10, "October");
		month.put(11, "November");
		month.put(12, "December");
		
		return month;
    }
    
    private Map<Integer,String> getTypeMap(){
		Map<Integer,String> type = new HashMap<Integer,String>();
		type.put(1, "Electric");
		type.put(2, "Water");
		type.put(3, "Internet");
		type.put(4, "Phone");
		
		return type;
    }
    
    private Map<Integer,String> getYearMap(){
		Map<Integer,String> year = new HashMap<Integer,String>();
		for(int i=1; i<=40;i++){
			year.put(i, ""+(1990+i));
		}
		return year;
    }
}