package com.ptit.finalexercise.dao;

import java.util.List;

import com.ptit.finalexercise.model.Tivi;
import com.ptit.finalexercise.model.TiviRequest;

public interface TiviDAO {
	boolean addTivi(Tivi tivi);
	List<Tivi> findTivi(TiviRequest request);
	List<Tivi> getAll();
	Tivi getById(Integer id);
	boolean delete(Integer id);
	List<Tivi> getByPage(Integer page);
}
