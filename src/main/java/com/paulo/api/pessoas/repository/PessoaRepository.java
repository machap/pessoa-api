package com.paulo.api.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.api.pessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findById(long id);
}
