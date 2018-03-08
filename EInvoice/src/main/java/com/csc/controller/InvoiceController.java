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
    @RequestMapping(value = "/searchInvoice", method = RequestMethod.GET)
    public ModelAndView searchInvoice(HttpServletRequest request) {
        int invoiceMonth = Integer.parseInt(request.getParameter("invoice_month"));
        invoiceServer.getSearch(invoiceMonth);
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

    private Map<Integer,String> getMonthMap(){
		Map<Integer,String> month = new LinkedHashMap<Integer,String>();
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
}