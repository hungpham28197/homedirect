package com.ptit.finalexercise.imp;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.finalexercise.dao.UserDAO;
import com.ptit.finalexercise.model.UserDto;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean registrationUser(UserDto user) {	
		if(findByEmail(user.getEmail())) {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);

			return true;
		} else {

			return false;
		}
	}

	@Transactional
	public boolean findByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from TB_USER where email = :email");
			query.setParameter("email", email);
			UserDto userDto = (UserDto) query.getSingleResult();
			if(userDto != null) {
				return false;
			}
		} catch (Exception e) {
			return true;
		}

		return true;
	}

	@Transactional
	public UserDto findByEmailSecurity(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TB_USER where email = :email");
		query.setParameter("email", email);
		UserDto userDto = (UserDto) query.getSingleResult();
		
		return userDto;
	}


	@Transactional
	public boolean login(String email, String password) {

		if(findByEmailAndPassword(email, password)) {
			return true;
		}

		return false;
	}

	@Transactional
	public boolean findByEmailAndPassword(String email, String password) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query query = session.createQuery("from TB_USER where email = :email and password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserDto userDto = (UserDto) query.getSingleResult();
			if(userDto != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

}
