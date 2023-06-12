package com.avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.avaliacao.entity.Pessoa;
import com.avaliacao.repository.PessoaRepository;

@Service
public class PessoaService extends AbstractService<Pessoa, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	PessoaRepository dao;


	@Override
	public CrudRepository<Pessoa, Long> getRepository() {
		return dao;
	}


	public List<Pessoa> funcionarios() {
		 
		return dao.findByFuncionario(true);
	}
}
