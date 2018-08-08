package com.ptit.finalexercise.dao;

import java.util.List;

import com.ptit.finalexercise.model.Category;

public interface CategoryDAO {
	List<Category> getAll();
	List<Object[]> statisticalByName();
	void add(String category);
}
