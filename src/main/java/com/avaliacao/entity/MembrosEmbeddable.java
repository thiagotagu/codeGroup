package com.avaliacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Columns;

import lombok.Data;

@Data
@Embeddable
public class MembrosEmbeddable implements Serializable{

	@Column(name = "idprojeto")
	Long  idProjeto;
	
	@Column(name = "idpessoa")
	Long idPessoa;
}
