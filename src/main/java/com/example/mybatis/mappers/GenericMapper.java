package com.example.mybatis.mappers;

import java.io.Serializable;
import java.util.List;

public interface GenericMapper <T, PK extends Serializable>{

	List<T> getAll();
	
	T findById(PK id);
	
	void insert(T object);
	
}
