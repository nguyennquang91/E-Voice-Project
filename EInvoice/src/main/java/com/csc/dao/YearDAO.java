package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.Year;

public interface YearDAO {

	public ArrayList<Year> getAll();
	public void addYear(Year year);
	public void deleteYear(int id);
	public Year getYear(int id);
	public Year updateYear(Year year);
	public Year getYearByValue(int value);
}