package com.ptit.finalexercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.finalexercise.dao.TiviDAO;
import com.ptit.finalexercise.imp.TiviImpl;
import com.ptit.finalexercise.model.Tivi;
import com.ptit.finalexercise.model.TiviRequest;

@Service
public class TiviService implements TiviDAO {


	@Autowired
	TiviImpl tiviImpl;
	
	public boolean addTivi(Tivi tivi) {
		return tiviImpl.addTivi(tivi);
	}

	public List<Tivi> findTivi(TiviRequest request) {
		return tiviImpl.findTivi(request);
	}

	public List<Tivi> getAll() {
		return tiviImpl.getAll();
	}

	public Tivi getById(Integer id) {
		return tiviImpl.getById(id);
	}

	public boolean delete(Integer id) {
		return tiviImpl.delete(id);
	}
	
	public List<Tivi> getByPage(Integer page) {
		return tiviImpl.getByPage(page);
	}

}
