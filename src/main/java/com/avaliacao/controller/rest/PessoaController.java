package com.avaliacao.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avaliacao.entity.Pessoa;
import com.avaliacao.service.PessoaService;

@Controller
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	@GetMapping
    public ResponseEntity<List<Pessoa>> lstAll()  {
		
	  return ResponseEntity.ok().body( service.findAll());
    }

	@PostMapping
	    public ResponseEntity<Pessoa> add(@RequestBody @Valid Pessoa pessoa)  {
			
		Pessoa retorno = service.save(pessoa);
		  return ResponseEntity.ok().body(retorno);
	    }

}
