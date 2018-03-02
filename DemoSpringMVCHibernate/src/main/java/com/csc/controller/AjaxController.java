package com.csc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csc.model.UserDTO;
import com.csc.service.UserService;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	UserService userServer;
	
	@RequestMapping(value = "/showall", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ArrayList<UserDTO> showAllUser(){
		return userServer.getAll();
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Void> addUser(@RequestBody UserDTO user){
		userServer.saveOrUpdate(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
