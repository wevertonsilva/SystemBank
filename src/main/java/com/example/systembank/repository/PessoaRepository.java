package com.example.systembank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.systembank.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
