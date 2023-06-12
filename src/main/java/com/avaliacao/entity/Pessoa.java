package com.avaliacao.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Pessoa {
	@Id
	 @GeneratedValue
	Long id;

	
	@NotEmpty(message = "Favor informar o nome")
	String nome;
	
	@Column(name = "datanascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
	Date dtNascimento;
	
	@Size( max = 14)
	@CPF(message = "CPF inválido")
	String cpf;
	
	boolean funcionario;

}
