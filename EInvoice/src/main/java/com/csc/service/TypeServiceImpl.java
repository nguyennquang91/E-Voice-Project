package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.TypeDAO;
import com.csc.model.Type;


@Service
public class TypeServiceImpl implements TypeService {

	TypeDAO typeDao;
	
	public TypeDAO getTypeDao() {
		return typeDao;
	}

	@Autowired
	public void setTypeDao(TypeDAO typeDao) {
		this.typeDao = typeDao;
	}

	public ArrayList<Type> getAll() {
		return getTypeDao().getAll();
	}

	public void addType(Type type){
		getTypeDao().addType(type);
	}
	
	public void deleteType(int id){
		getTypeDao().deleteType(id);
	}
	
	public Type getType(int id){
		return getTypeDao().getType(id);
	}
	
	public Type getTypeByName(String name){
		return getTypeDao().getTypeByName(name);
	}
	
	public Type updateType(Type type){
		return getTypeDao().updateType(type);
	}
}
