package com.csc.service;

import java.util.ArrayList;

import com.csc.model.Month;

public interface MonthService {

	public ArrayList<Month> getAll();
	public void addMonth(Month Month);
	public void deleteMonth(int id);
	public Month getMonth(int id);
	public Month updateMonth(Month Month);
	public Month getMonthByName(String name);
}