package com.avaliacao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.avaliacao.entity.Projeto;
import com.avaliacao.enumerated.ProjetoStatusEnum;
import com.avaliacao.repository.ProjetoRepository;

	
	@Service
	public class ProjetoService  extends AbstractService<Projeto, Long>{
		
 
		private static final long serialVersionUID = 1L;
		@Autowired
		ProjetoRepository dao;
		@Override
		public CrudRepository<Projeto, Long> getRepository() {
			return dao;
		}
 
		public Page<Projeto> search(Pageable pageable) {
	        return dao.search(
	        		pageable);
	    }

		public void delete(Long id) {
				Projeto projeto = findById(id);
				
				if (!projeto.getStatus().equals(ProjetoStatusEnum.INICIADO.name()) && 
						!projeto.getStatus().equals(ProjetoStatusEnum.EM_ANDAMENTO.name()) && 
						!projeto.getStatus().equals(ProjetoStatusEnum.ENCERRADO.name())&& 
						!projeto.getStatus().equals(ProjetoStatusEnum.CANCELADO.name())) {
					projeto.setStatus(ProjetoStatusEnum.CANCELADO.name());
					save(projeto);
				}
			
		}

		public void workflow(Long id, String status) {
			Projeto projeto = findById(id);
			status = status.toUpperCase();
			if (status.equals(ProjetoStatusEnum.CANCELADO )) {
				delete(id);
			} else {
				projeto.setStatus(status);
				if (status.equals(ProjetoStatusEnum.INICIADO.name())) {
					projeto.setDtInicio(new Date());
				}
				if (status.equals(ProjetoStatusEnum.ENCERRADO.name())) {
					projeto.setDtFim(new Date());
				}
				if (status.equals(ProjetoStatusEnum.EM_ANDAMENTO.name()) && projeto.getDtInicio()==null) {
					projeto.setDtInicio(new Date());
				}
				save(projeto);
				
			}
			
		}
 

}
