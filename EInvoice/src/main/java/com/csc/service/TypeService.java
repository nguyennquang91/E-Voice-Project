package com.csc.service;

import java.util.ArrayList;
import java.util.List;

import com.csc.model.Type;

public interface TypeService {

	public ArrayList<Type> getAll();
	public void addType(Type Type);
	public void deleteType(int id);
	public Type getType(int id);
	public Type updateType(Type Type);
	public List<Type> getAllByUserId(int id);
}