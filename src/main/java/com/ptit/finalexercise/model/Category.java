package com.ptit.finalexercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TB_CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	
	private String name;
	
	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
