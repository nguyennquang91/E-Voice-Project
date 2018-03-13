package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.Type;

public interface TypeDAO {

	public ArrayList<Type> getAll();
	public void addType(Type type);
	public void deleteType(int id);
	public Type getType(int id);
	public Type updateType(Type type);
	public Type getTypeByName(String name);
}
