package com.avaliacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.avaliacao.entity.Membros;
import com.avaliacao.repository.MembroRepository;


@Service
public class MembroService extends AbstractService<Membros, Long>{
	@Autowired
	MembroRepository dao;
	
	@Override
	public CrudRepository<Membros, Long> getRepository() {
		return dao;
	}

}
