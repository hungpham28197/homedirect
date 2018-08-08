package com.ptit.finalexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.finalexercise.dao.UserDAO;
import com.ptit.finalexercise.imp.UserImpl;
import com.ptit.finalexercise.model.UserDto;

@Service
public class UserService implements UserDAO{

	@Autowired
	UserImpl userImpl;

	public boolean registrationUser(UserDto user) {
		return userImpl.registrationUser(user);
	}

	public boolean login(String email, String password) {
		return userImpl.login(email, password);
	}
}
