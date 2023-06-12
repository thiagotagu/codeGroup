package com.avaliacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.avaliacao.entity.Pessoa;
import com.avaliacao.repository.PessoaRepository;
import com.avaliacao.service.PessoaService;


@ContextConfiguration(classes = {PessoaService.class})
@ExtendWith(SpringExtension.class)
public class PessoaServiceTest {

	
	  @MockBean
	    private PessoaRepository pessoaRepository;

	   @Autowired
	    private PessoaService pessoaService;

	   

	    @Test
	    public void testFuncionarios() {
	        // Criação de dados de teste
	        Pessoa pessoa1 = new Pessoa();
	        pessoa1.setFuncionario(true);

	        Pessoa pessoa2 = new Pessoa();
	        pessoa2.setFuncionario(false);

	        List<Pessoa> pessoas = new ArrayList<>();
	        pessoas.add(pessoa1);
	        pessoas.add(pessoa2);

	        when(pessoaRepository.findByFuncionario(true)).thenReturn(pessoas);

	        List<Pessoa> resultado = pessoaService.funcionarios();

	        assertEquals(2, resultado.size());
	        assertEquals(pessoa1, resultado.get(0));
	    }
	    
	    @Test
	    public void testBuscarPorId() {
	        Long id = 1L;
	        Pessoa pessoa = new Pessoa();
	        pessoa.setId(id);

	        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

	        Pessoa resultado = pessoaService.findById(id);
	        assertEquals(pessoa, resultado);
	    }
	    
	    @Test
	    public void testSalvarPessoa() {
	        Pessoa pessoa = new Pessoa();
	        pessoa.setNome("João");
	        pessoa.setFuncionario(true);

	        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

	        Pessoa resultado = pessoaService.save(pessoa);

	        assertEquals(pessoa, resultado);
	    }
}
