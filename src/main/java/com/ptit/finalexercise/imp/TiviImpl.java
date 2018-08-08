package com.ptit.finalexercise.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.finalexercise.dao.TiviDAO;
import com.ptit.finalexercise.model.Tivi;
import com.ptit.finalexercise.model.TiviRequest;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TiviImpl implements TiviDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addTivi(Tivi tivi) {
		if(findByName(tivi.getName())) {
			Session session = sessionFactory.getCurrentSession();
			session.save(tivi);

			return true;
		} else {

			return false;
		}
	}

	@Transactional
	public boolean findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from TB_TIVI where name = :name");
			query.setParameter("name", name);
			Tivi tivi = (Tivi) query.getSingleResult();
			if(tivi != null) {
				return false;
			}
		} catch (Exception e) {
			return true;
		}

		return true;
	}

	@Transactional
	public List<Tivi> findTivi(TiviRequest request) {
		List<Tivi> list = new ArrayList<Tivi>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(createQuery(request));
		list = query.getResultList();

		return list;
	}

	public String createQuery(TiviRequest request) {
		String query = "from TB_TIVI where ";
		if(!request.getName().isEmpty()) {
			query += "name = " + "'" + request.getName() + "'" + " and ";
		}
		if(!request.getCategory().isEmpty()) {
			query += "category = " + "'" + request.getCategory() + "'" + " and ";
		}
		query += "bought = " +"'" + request.getBought()  + "'" +" and price between " +"'"+request.getPriceMin()  + "'" + " and " + "'" + request.getPriceMax()  + "'";

		return query;
	}

	@Transactional
	public List<Tivi> getAll() {
		List<Tivi> list = new ArrayList<Tivi>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TB_TIVI");
		list = query.getResultList();

		return list;
	}

	@Transactional
	public Tivi getById(Integer id) {
		Tivi tivi = new Tivi();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TB_TIVI where id = :id");
		query.setParameter("id", id);
		tivi = (Tivi) query.getSingleResult();

		return tivi;
	}

	@Transactional
	public boolean delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from TB_TIVI where id= :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return true;
	}
	@Transactional
	public List<Tivi> getByPage(Integer page) {
		Session session = sessionFactory.getCurrentSession();
		Integer index = page <= 1? 0 : (page -1) * 3;
		Query query = session.createQuery("FROM TB_TIVI");
		query.setFirstResult(index);
		query.setMaxResults(3);
		
		return query.getResultList();
	}

}
