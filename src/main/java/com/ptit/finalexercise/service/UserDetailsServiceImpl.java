package com.ptit.finalexercise.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.finalexercise.imp.UserImpl;
import com.ptit.finalexercise.model.Role;
import com.ptit.finalexercise.model.UserDto;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserImpl userImpl;
	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  UserDto user = userImpl.findByEmailSecurity(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
	        Set<Role> roles = user.getRoles();
	        for (Role role : roles) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        return new org.springframework.security.core.userdetails.User(
	                user.getEmail(), user.getPassword(), grantedAuthorities);
	}

}
