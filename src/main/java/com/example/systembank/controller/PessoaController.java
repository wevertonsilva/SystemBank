package com.example.systembank.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.systembank.entity.Pessoa;
import com.example.systembank.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas(){
		return ResponseEntity.ok(pessoaService.listarPessoas());
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody Pessoa pessoa, BindingResult result) throws Exception{
		Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();
		return pessoaSalva != null ? ResponseEntity.created(uri).body(pessoaSalva) : ResponseEntity.badRequest().build();
	}
	
}
