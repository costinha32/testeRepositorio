package com.ifsc.tds.caio.gabriel.jose.dao;

import java.util.List;

import com.ifsc.tds.caio.gabriel.jose.enity.Contato;

public interface DAO<T> {

	Contato get(Integer idContato);
	
	List<T> getAll();

	int save(T t);

	boolean update(T t, String[] params);

	boolean delete(T t);

}
