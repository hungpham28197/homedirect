package com.ptit.finalexercise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.ptit.finalexercise.model.Category;
import com.ptit.finalexercise.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/category/getAll", method = RequestMethod.GET)
	public String getAll(WebRequest request, Model model) {
		List<Category> list = new ArrayList<Category>();
		list = categoryService.getAll();
		model.addAttribute("listCategory", list);
		
		return "addTivi";
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String add(WebRequest request, Model model, @RequestParam("nameCategory") String name) {
		categoryService.add(name);
		return "addTivi";
	}
	
}
