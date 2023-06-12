package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avaliacao.service.ProjetoService;

@Controller
@RequestMapping("/")
public class indexController {

	@Autowired
	ProjetoService service;
	 @GetMapping
	    public String homePage(Model model) {
		 
		 model.addAttribute("dashboard", service.findAll());
		 
	        return "home";
	    }
}
