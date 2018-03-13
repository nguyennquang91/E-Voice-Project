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
import com.csc.service.MonthService;
import com.csc.service.TypeService;
import com.csc.service.UserService;
import com.csc.service.YearService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceServer;
	
	@Autowired
	UserService userServer;
	
	@Autowired
	TypeService typeServer;

	@Autowired
	MonthService monthServer;

	@Autowired
	YearService yearServer;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listInvoice(ModelAndView model, Principal principal) throws IOException {
		String username = principal.getName();
		
		User user = userServer.getUserByName(username);
		int userId = user.getId();
		
    	List<Invoice> invoiceList = invoiceServer.getAllByUserId(userId);

    	model.addObject("invoiceList", invoiceList);
        model.setViewName("invoice");
        return model;
    }
	
	@RequestMapping(value = "/newInvoice", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model, Principal principal) {
		String username = principal.getName();
		User user = userServer.getUserByName(username);
		System.out.println(user.getEmail() + "/" + user.getPassword() + "/" + user.getUsername() + "/" + user.getId());
        Invoice invoice = new Invoice();
        invoice.setUser(user);
        model.addObject("invoice", invoice);
    	model.addObject("monthList", monthServer.getAll());
    	model.addObject("typeList", typeServer.getAllByUserId(user.getId()));
    	model.addObject("yearList", yearServer.getAll());
        model.setViewName("InvoiceForm");
        return model;
    }
	
	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    public ModelAndView saveInvoice(@ModelAttribute Invoice invoice) {
        if (invoice.getId() != 0) {
        	invoiceServer.updateInvoice(invoice);
        }
        else{
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
        int userId = invoice.getUser().getId();
        ModelAndView model = new ModelAndView("InvoiceForm");
        model.addObject("invoice", invoice);
        model.addObject("monthList", monthServer.getAll());
    	model.addObject("typeList", typeServer.getAllByUserId(userId));
    	model.addObject("yearList", yearServer.getAll());
        return model;
    }
    
}