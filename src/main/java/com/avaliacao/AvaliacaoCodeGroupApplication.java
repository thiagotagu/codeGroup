package com.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.avaliacao.service.CargaMassaTesteFAKE;
import com.avaliacao.service.PessoaService;
import com.avaliacao.service.ProjetoService;

@SpringBootApplication
public class AvaliacaoCodeGroupApplication {

	
@Autowired
CargaMassaTesteFAKE carga;
	
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoCodeGroupApplication.class, args);
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		carga.gerarCarga();
	}
	

}
