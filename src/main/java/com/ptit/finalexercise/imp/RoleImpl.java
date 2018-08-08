package com.ptit.finalexercise.imp;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.finalexercise.dao.RoleDAO;
import com.ptit.finalexercise.model.Role;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RoleImpl implements RoleDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Role findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TB_ROLE where name = :name");
		query.setParameter("name", name);
		Role role = (Role) query.getSingleResult();

		return role;
	}

}
