package com.ptit.finalexercise.dao;

import com.ptit.finalexercise.model.UserDto;

public interface UserDAO {
	boolean registrationUser(UserDto user);
	boolean login(String email, String password);
}
