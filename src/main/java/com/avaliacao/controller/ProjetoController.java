package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.avaliacao.entity.Projeto;
import com.avaliacao.service.PessoaService;
import com.avaliacao.service.ProjetoService;

@Controller
 @RequestMapping("projeto")
public class ProjetoController {
	
	@Autowired
	ProjetoService service;
	
	@Autowired
	PessoaService pessoaService;
 
		@GetMapping 
	    public String indexProjeto(Model model, @PageableDefault(size = 5) Pageable pageable,RedirectAttributes redirectAttributes) {
		
			Projeto teste = service.findById(1L);
			teste.getMembros();
			
		 model.addAttribute("projetopaginacao", service.search(pageable));
		 model.addAttribute("lstFuncionarios", pessoaService.funcionarios());
		 model.addAttribute("projeto", new Projeto());
	        return "projeto/index";
	    }
		
		@GetMapping("{pg}/{id}")
	    public String obterId(Model model , @PathVariable(value = "pg") int pg , @PathVariable(value = "id") Long id,RedirectAttributes redirectAttributes) {
			
			model.addAttribute("projetopaginacao", service.search(PageRequest.of(pg, 5, Sort.by("id"))));
			model.addAttribute("lstFuncionarios", pessoaService.funcionarios());
			model.addAttribute("projeto", service.findById(id));
	        return  "projeto/index";
	    }
		
		
		@PostMapping 
	    public String gravarProjeto(Model model, @ModelAttribute Projeto projeto,BindingResult result, RedirectAttributes redirectAttributes) {
			
			service.save(projeto);
			  redirectAttributes.addFlashAttribute("message", "Projeto "+projeto.getNome()+" gravado com Sucesso");
			 return "redirect:/projeto";
			
	    }
		
		
		@PostMapping("{id}")
		@ResponseBody
	    public String cancelarProjeto(@PathVariable(value = "id") Long id  ) {
			  service.delete(id);
			  return "redirect:/projeto";
			
	    }
		
		
		@PostMapping("workflow/{id}/{status}")
		@ResponseBody
	    public Boolean workflow(@PathVariable(value = "id") Long id , @PathVariable(value = "status") String status) {
			
			service.workflow(id,status);
			 return true;
			
	    }
		
		 

}
