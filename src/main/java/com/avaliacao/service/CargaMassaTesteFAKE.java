package com.avaliacao.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entity.Membros;
import com.avaliacao.entity.MembrosEmbeddable;
import com.avaliacao.entity.Pessoa;
import com.avaliacao.entity.Projeto;
import com.avaliacao.enumerated.ProjetoRiscoEnum;
import com.avaliacao.enumerated.ProjetoStatusEnum;

@Service
public class CargaMassaTesteFAKE {
	
	@Autowired
	ProjetoService projetoService;
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	MembroService membroService;
	
	public void gerarCarga() {
		cargaProjeto();
		cargaPessoa();
		
		Membros membro = new Membros();
		MembrosEmbeddable membroID =new  MembrosEmbeddable();
		
		membroID.setIdPessoa(7L);
	 	membroID.setIdProjeto(1L);
 
 
		membro.setId(membroID);
		membro.setPessoa(pessoaService.findById(7L));
		membro.setProjeto(projetoService.findById(1L));
		membroService.save(membro);
		
		 
		
	}

	private void cargaProjeto() {
		List<Projeto> lstProjetoFake = new ArrayList<Projeto>(6);
		
		Projeto proj1= new Projeto();
		proj1.setNome("Alfa");
		proj1.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj1.setStatus(ProjetoStatusEnum.EM_ANALISE.name());
		proj1.setDescricao("descricao Projeto Alfa");
		proj1.setOrcamento(new BigDecimal(1000.00));
		Calendar cal = Calendar.getInstance();
		proj1.setDtInicio(cal.getTime());
		cal.add(Calendar.MONTH, 1);
		proj1.setDtPrevisao(cal.getTime());
	 
		
		Projeto proj2= new Projeto();
		proj2.setNome("Beta");
		proj2.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj2.setStatus(ProjetoStatusEnum.EM_ANALISE.name());
		proj2.setDescricao("descricao Projeto Beta");
		proj2.setOrcamento(new BigDecimal(2000.00));
		Calendar cal2 = Calendar.getInstance();
		proj2.setDtInicio(cal2.getTime());
		cal2.add(Calendar.MONTH, 4);
		proj2.setDtPrevisao(cal2.getTime());
		
		Projeto proj3= new Projeto();
		proj3.setNome("Gama");
		proj3.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj3.setStatus(ProjetoStatusEnum.INICIADO.name());
		proj3.setDescricao("descricao Projeto Gama");
		proj3.setOrcamento(new BigDecimal(2000.00));
		Calendar cal3 = Calendar.getInstance();
		proj3.setDtInicio(cal3.getTime());
		cal3.add(Calendar.MONTH, 3);
		proj3.setDtPrevisao(cal3.getTime());
		
		
		Projeto proj4= new Projeto();
		proj4.setNome("Delta");
		proj4.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj4.setStatus(ProjetoStatusEnum.EM_ANDAMENTO.name());
		proj4.setDescricao("descricao Projeto Dama");
		proj4.setOrcamento(new BigDecimal(4000.00));
		Calendar cal4 = Calendar.getInstance();
		proj4.setDtInicio(cal4.getTime());
		cal4.add(Calendar.MONTH, 3);
		proj4.setDtPrevisao(cal3.getTime());
		
		Projeto proj5= new Projeto();
		proj5.setNome("Epsilon");
		proj5.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj5.setStatus(ProjetoStatusEnum.INICIADO.name());
		proj5.setDescricao("descricao Projeto Epsilon");
		proj5.setOrcamento(new BigDecimal(4000.00));
		Calendar cal5 = Calendar.getInstance();
		proj5.setDtInicio(cal4.getTime());
		cal5.add(Calendar.MONTH, 5);
		proj5.setDtPrevisao(cal5.getTime());
		
		Projeto proj6= new Projeto();
		proj6.setNome("Zeta");
		proj6.setRisco(ProjetoRiscoEnum.BAIXO.name());
		proj6.setStatus(ProjetoStatusEnum.INICIADO.name());
		proj6.setDescricao("descricao Projeto Zeta");
		proj6.setOrcamento(new BigDecimal(4000.00));
		Calendar cal6 = Calendar.getInstance();
		proj6.setDtInicio(cal4.getTime());
		cal6.add(Calendar.MONTH, 3);
		proj6.setDtPrevisao(cal3.getTime());
		
		
		lstProjetoFake.add(proj1);
		lstProjetoFake.add(proj2);
		lstProjetoFake.add(proj3);
		lstProjetoFake.add(proj4);
		lstProjetoFake.add(proj5);
		lstProjetoFake.add(proj6);
		
		projetoService.saveAll(lstProjetoFake);
		
	}

	private void cargaPessoa() {
		List<Pessoa> lstPessoa = new ArrayList<>();
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Thiago Rodrigues");
		pessoa1.setCpf("833.550.880-13");
		pessoa1.setFuncionario(true);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Joao Cleber");
		pessoa2.setCpf("833.550.880-13");
		pessoa2.setFuncionario(true);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Neymar Senior");
		pessoa3.setCpf("833.550.880-13");
		pessoa3.setFuncionario(true);
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Maria Xuxa");
		pessoa4.setCpf("833.550.880-13");
		pessoa4.setFuncionario(true);
		
		Pessoa pessoa5 = new Pessoa();
		pessoa5.setNome("Fatima Desempregada");
		pessoa5.setCpf("833.550.880-13");
		pessoa5.setFuncionario(false);
		
		
		lstPessoa.add(pessoa1);
		lstPessoa.add(pessoa2);
		lstPessoa.add(pessoa3);
		lstPessoa.add(pessoa4);
		lstPessoa.add(pessoa5);
		
		pessoaService.saveAll(lstPessoa);
		
	}

}
