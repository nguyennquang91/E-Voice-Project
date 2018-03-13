package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.MonthDAO;
import com.csc.model.Month;


@Service
public class MonthServiceImpl implements MonthService {

	MonthDAO monthDao;
	
	public MonthDAO getMonthDao() {
		return monthDao;
	}

	@Autowired
	public void setMonthDao(MonthDAO monthDao) {
		this.monthDao = monthDao;
	}

	public ArrayList<Month> getAll() {
		return getMonthDao().getAll();
	}

	public void addMonth(Month month){
		getMonthDao().addMonth(month);
	}
	
	public void deleteMonth(int id){
		getMonthDao().deleteMonth(id);
	}
	
	public Month getMonth(int id){
		return getMonthDao().getMonth(id);
	}
	
	public Month getMonthByName(String name){
		return getMonthDao().getMonthByName(name);
	}
	
	public Month updateMonth(Month month){
		return getMonthDao().updateMonth(month);
	}
}
