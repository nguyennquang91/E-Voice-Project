package com.csc.service;

import java.util.ArrayList;

import com.csc.model.Year;

public interface YearService {

	public ArrayList<Year> getAll();
	public void addYear(Year Year);
	public void deleteYear(int id);
	public Year getYear(int id);
	public Year updateYear(Year Year);
	public Year getYearByValue(int value);
}