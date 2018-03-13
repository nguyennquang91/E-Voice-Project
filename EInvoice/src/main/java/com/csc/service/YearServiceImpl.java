package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.YearDAO;
import com.csc.model.Year;


@Service
public class YearServiceImpl implements YearService {

	YearDAO yearDao;
	
	public YearDAO getYearDao() {
		return yearDao;
	}

	@Autowired
	public void setYearDao(YearDAO yearDao) {
		this.yearDao = yearDao;
	}

	public ArrayList<Year> getAll() {
		return getYearDao().getAll();
	}

	public void addYear(Year year){
		getYearDao().addYear(year);
	}
	
	public void deleteYear(int id){
		getYearDao().deleteYear(id);
	}
	
	public Year getYear(int id){
		return getYearDao().getYear(id);
	}
	
	public Year getYearByValue(int value){
		return getYearDao().getYearByValue(value);
	}
	
	public Year updateYear(Year year){
		return getYearDao().updateYear(year);
	}
}
