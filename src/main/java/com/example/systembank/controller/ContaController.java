package com.example.systembank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.systembank.entity.Conta;
import com.example.systembank.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> listarContas(){
		return ResponseEntity.ok(service.listarContas());
	}
	
}
