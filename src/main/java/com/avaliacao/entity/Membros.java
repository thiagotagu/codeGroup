package com.avaliacao.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
public class Membros {
	 @EmbeddedId
	MembrosEmbeddable id;
	 
	 	@ManyToOne
	    @MapsId("idProjeto")
	    @JoinColumn(name = "idprojeto")
	    Projeto projeto;
	 	
	 	@ManyToOne
	    @MapsId("idpessoa")
	    @JoinColumn(name = "idpessoa")
	    Pessoa pessoa;
	 	
	 	


}
