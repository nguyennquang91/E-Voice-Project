package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.Month;

public interface MonthDAO {

	public ArrayList<Month> getAll();
	public void addMonth(Month month);
	public void deleteMonth(int id);
	public Month getMonth(int id);
	public Month updateMonth(Month month);
	public Month getMonthByName(String name);
}
