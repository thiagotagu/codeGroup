package com.avaliacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.avaliacao.entity.Projeto;
import com.avaliacao.enumerated.ProjetoStatusEnum;
import com.avaliacao.repository.ProjetoRepository;
import com.avaliacao.service.PessoaService;
import com.avaliacao.service.ProjetoService;


@ContextConfiguration(classes = {ProjetoService.class})
@ExtendWith(SpringExtension.class)
public class ProjetoServiceTest {

	 @MockBean
    private ProjetoRepository projetoRepository;

	 @Autowired
    private ProjetoService projetoService;

 
    @Test
    public void testSearch() {
        Pageable pageable = Pageable.unpaged();
        Page<Projeto> expectedPage = new PageImpl<>(new ArrayList<>());
        when(projetoRepository.search(pageable)).thenReturn(expectedPage);

        Page<Projeto> result = projetoService.search(pageable);

        assertEquals(expectedPage, result);
        verify(projetoRepository).search(pageable);
    }

 


    @Test
    public void testWorkflow_Iniciado() {
        Long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setId(id);

        when(projetoRepository.findById(id)).thenReturn(Optional.of(projeto));

        projetoService.workflow(id, ProjetoStatusEnum.INICIADO.name());

        assertEquals(ProjetoStatusEnum.INICIADO.name(), projeto.getStatus());
        verify(projetoRepository).save(projeto);
    }

    @Test
    public void testWorkflow_EmAndamento() {
        Long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setId(id);

        when(projetoRepository.findById(id)).thenReturn(Optional.of(projeto));

        projetoService.workflow(id, ProjetoStatusEnum.EM_ANDAMENTO.name());

        assertEquals(ProjetoStatusEnum.EM_ANDAMENTO.name(), projeto.getStatus());
        assertEquals(new Date(), projeto.getDtInicio());
        verify(projetoRepository).save(projeto);
    }
    
    @Test
    public void testWorkflow_Encerrado() {
        Long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setId(id);

        when(projetoRepository.findById(id)).thenReturn(Optional.of(projeto));

        projetoService.workflow(id, ProjetoStatusEnum.ENCERRADO.name());

        assertEquals(ProjetoStatusEnum.ENCERRADO.name(), projeto.getStatus());
        verify(projetoRepository).save(projeto);
    }

}
