package com.example.systembank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.systembank.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
