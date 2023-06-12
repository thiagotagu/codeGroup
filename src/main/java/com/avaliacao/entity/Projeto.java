package com.avaliacao.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Projeto {
	
	@Id
	 @GeneratedValue
	Long id;
	
	@Size( max = 200)
	String nome;
	
	@Size( max = 5000)
	String descricao;
	
	@Size( max = 45)
	String status;
	
	@Size( max = 45)
	String risco;
	
	BigDecimal orcamento;
	
	@Column(name = "data_inicio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
	Date dtInicio;
	
	@Column(name = "data_fim")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
	Date dtFim;
	
	@Column(name = "data_previsao_fim ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
	Date dtPrevisao;
	
	@Column(name = "idgerente")
	Long idGerente;
	
	@ManyToMany
    @JoinColumn(name = "idProjeto")
	 List<Membros> membros; 
	
	
	

}