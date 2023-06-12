package com.avaliacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avaliacao.entity.Projeto;

@Repository
	public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
    @Query("FROM Projeto p ")
     Page<Projeto> search(
             Pageable pageable);

}
