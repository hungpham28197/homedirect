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

import com.ptit.finalexercise.exception.PageException;
import com.ptit.finalexercise.model.Category;
import com.ptit.finalexercise.model.Tivi;
import com.ptit.finalexercise.service.CategoryService;
import com.ptit.finalexercise.service.TiviService;

@Controller
public class IndexController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	TiviService tiviService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(WebRequest request, Model model, @RequestParam(name="page", defaultValue = "1") Integer page) throws PageException {
		List<Tivi> list = new ArrayList<Tivi>();
		list = tiviService.getByPage(page);
		Integer totalItem = tiviService.getAll().size();
		
		List<Category> listCategory = new ArrayList<Category>();
		listCategory = categoryService.getAll();
		
		Integer totalPage = totalItem%3 == 0? totalItem/3 : totalItem/3+1;
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("listTivi", list);
		
		if(page == 1) {
			model.addAttribute("isDisable", "disable");
		}
		
		if(page == totalPage) {
			model.addAttribute("isDisableNext", "disableNext");
		}
		
		if(page < 1 || page > totalPage) {
			throw new PageException("Page khong hop le");
		}
		
		List<Object[]> payments = categoryService.statisticalByName();
		model.addAttribute("listCategory", payments);
		
		return "index";
	}
	
}
