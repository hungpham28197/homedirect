package com.ptit.finalexercise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.ptit.finalexercise.model.Category;
import com.ptit.finalexercise.model.Tivi;
import com.ptit.finalexercise.model.TiviRequest;
import com.ptit.finalexercise.service.CategoryService;
import com.ptit.finalexercise.service.TiviService;

@Controller
@RequestMapping("/tivi")
public class TiviController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	TiviService tiviService;

	@RequestMapping(value="/admin/add", method=RequestMethod.GET)
	public String showFormAddTivi(WebRequest request, Model model) {
		List<Category> list = new ArrayList<Category>();
		list = categoryService.getAll();
		model.addAttribute("listCategory", list);

		return "addTivi";
	}

	@RequestMapping(value="/admin/processAdd", method=RequestMethod.POST)
	public String processAdd(WebRequest request, Model model, @ModelAttribute("tivi") Tivi tivi) {

		if(tiviService.addTivi(tivi)) {
			model.addAttribute("alert", "Thêm tivi thành công");
		} else {
			model.addAttribute("alert", "Tivi đã tồn tại");
		}

		return "addTivi";
	}

	@RequestMapping(value="/admin/processFind", method=RequestMethod.POST)
	public String find(WebRequest request, Model model, @RequestParam("name") String name,
	@RequestParam("category") String category, @RequestParam("priceMin") Double priceMin, @RequestParam("priceMax") Double priceMax,
	@RequestParam(value = "bought", required = false) Integer bought) {
		List<Tivi> list = new ArrayList<Tivi>();
		
		TiviRequest tiviRequest = new TiviRequest();
		
		if(name != null) {
			tiviRequest.setName(name);
		}
		if(category != null) {
			tiviRequest.setCategory(category);
		}
		if(priceMin != null) {
			tiviRequest.setPriceMin(priceMin);
		} else {
			tiviRequest.setPriceMin(0.0);
		}
		if(priceMax != null) {
			tiviRequest.setPriceMax(priceMax);
		} else {
			tiviRequest.setPriceMax(Double.MAX_VALUE);
		}
		if(bought != null) {
			tiviRequest.setBought(bought);
		} else {
			tiviRequest.setBought(0);
		}
		list = tiviService.findTivi(tiviRequest);
		
		model.addAttribute("listTivi", list);

		return "addTivi";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String getById(WebRequest request, Model model, @RequestParam(name="id") Integer id) {
		Tivi tivi = tiviService.getById(id);
		model.addAttribute("img", tivi.getImage());
		model.addAttribute("title", tivi.getName());
		model.addAttribute("desc", formatSubscription(tivi.getSubscription()));
		model.addAttribute("price", tivi.getPrice());
		model.addAttribute("discounted", tivi.getDiscounted());
		
		return "detail";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(WebRequest request, Model model, @RequestParam(name="id") Integer id) {
		tiviService.delete(id);
		
		return "addTivi";
	}
	
	public String[] formatSubscription(String subScription) {
		String[] parts = subScription.split("\\n");
		
		return parts;
	}
}
