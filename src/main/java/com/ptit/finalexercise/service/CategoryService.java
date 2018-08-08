package com.ptit.finalexercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.finalexercise.dao.CategoryDAO;
import com.ptit.finalexercise.imp.CategoryImpl;
import com.ptit.finalexercise.model.Category;

@Service
public class CategoryService implements CategoryDAO {

	@Autowired
	CategoryImpl categoryImpl;
	
	public List<Category> getAll() {
		
		return categoryImpl.getAll();
	}

	public List<Object[]> statisticalByName() {
		return categoryImpl.statisticalByName();
	}

	public void add(String category) {
		categoryImpl.add(category);
	}


}
