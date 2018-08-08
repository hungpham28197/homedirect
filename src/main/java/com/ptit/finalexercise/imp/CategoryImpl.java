package com.ptit.finalexercise.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.finalexercise.dao.CategoryDAO;
import com.ptit.finalexercise.model.Category;
import com.ptit.finalexercise.model.Tivi;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TB_CATEGORY");
		categories = query.getResultList();
		
		return categories;
	}

	@Transactional
	public List<Object[]> statisticalByName() {
		Session session = sessionFactory.getCurrentSession();
		ProjectionList projectionList = Projections.projectionList();        
		projectionList.add(Projections.groupProperty("category"))
		        .add(Projections.rowCount());
		Criteria criteria  = session.createCriteria(Tivi.class);
		criteria.setProjection(projectionList);
		List<Object[]> categories = criteria.list();
		
		return categories;
	}

	@Transactional
	public void add(String nameCategory) {
			Category category = new Category();
			category.setName(nameCategory);
			
			Session session = sessionFactory.getCurrentSession();
			session.save(category);
	}

}
