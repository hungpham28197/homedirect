package com.ptit.finalexercise.dao;

import com.ptit.finalexercise.model.Role;

public interface RoleDAO {
	Role findByName(String name);
}
