package com.ptit.finalexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.finalexercise.dao.RoleDAO;
import com.ptit.finalexercise.imp.RoleImpl;
import com.ptit.finalexercise.model.Role;

@Service
public class RoleService implements RoleDAO {
	
	@Autowired
	RoleImpl roleImpl;
	
	public Role findByName(String name) {
		return roleImpl.findByName(name);
	}

}
