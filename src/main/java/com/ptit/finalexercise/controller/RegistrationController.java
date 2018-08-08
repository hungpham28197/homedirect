package com.ptit.finalexercise.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.ptit.finalexercise.model.UserDto;
import com.ptit.finalexercise.service.UserService;

@Controller
public class RegistrationController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/registration", method=RequestMethod.GET)
	public String showRegistationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		
		return "registration";
	}
	
	@RequestMapping(value="/user/processRegister", method=RequestMethod.POST)
	public String processRegister(WebRequest request, Model model,@Valid @ModelAttribute("userDto") UserDto user, BindingResult result) {
		if(result.hasErrors()) {
			
			return "registration";
		} else {
			if(userService.registrationUser(user)) {
				model.addAttribute("alert", "Đăng kí thành công");
			} else {
				model.addAttribute("alert", "Email đã tồn tại");
			}
		}
		
		return "registration";
	}
	
}
