package com.csc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.csc.model.Invoice;
import com.csc.service.InvoiceService;

@Controller

public class InvoiceController {

	@Autowired
	InvoiceService invoiceServer;
	
	@RequestMapping(value = "/showall", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public  ResponseEntity<ArrayList<Invoice>> showAllInvoice(){
		return new ResponseEntity<ArrayList<Invoice>>(invoiceServer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/")
    public ModelAndView listInvoice(ModelAndView model) throws IOException {
        ArrayList<Invoice> listInvoice = invoiceServer.getAll();
        model.addObject("listInvoice", listInvoice);
        model.setViewName("invoice");
        return model;
    }
	
	
	@RequestMapping(value = "/newInvoice", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
		model.addObject("monthList", this.getMonthMap());
		
        Invoice invoice = new Invoice();
        model.addObject("invoice", invoice);
        model.setViewName("InvoiceForm");
        return model;
    }
	
	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    public ModelAndView saveInvoice(@ModelAttribute Invoice invoice) {
        if (invoice.getInvoiceId() == 0) { // if invoice id is 0 then creating the
            // invoice other updating the invoice
            invoiceServer.addInvoice(invoice);
        } else {
            invoiceServer.updateInvoice(invoice);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteInvoice", method = RequestMethod.GET)
    public ModelAndView deleteInvoice(HttpServletRequest request) {
        int invoiceId = Integer.parseInt(request.getParameter("invoice_id"));
        invoiceServer.deleteInvoice(invoiceId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editInvoice", method = RequestMethod.GET)
    public ModelAndView editInvoice(HttpServletRequest request) {
        int invoiceId = Integer.parseInt(request.getParameter("invoice_id"));
        Invoice invoice = invoiceServer.getInvoice(invoiceId);
        ModelAndView model = new ModelAndView("InvoiceForm");
        model.addObject("invoice", invoice);
		model.addObject("monthList", this.getMonthMap());
 
        return model;
    }

    private Map<String,String> getMonthMap(){
		Map<String,String> month = new LinkedHashMap<String,String>();
		month.put("January", "January");
		month.put("February", "February");
		month.put("March", "March");
		month.put("April", "April");
		month.put("May", "May");
		month.put("June", "June");
		month.put("July", "July");
		month.put("August", "August");
		month.put("September", "September");
		month.put("October", "October");
		month.put("November", "November");
		month.put("December", "December");
		
		return month;
    }
}