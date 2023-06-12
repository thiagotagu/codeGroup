package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.entity.Membros;


@Repository
	public interface MembroRepository extends JpaRepository<Membros, Long> {

}
