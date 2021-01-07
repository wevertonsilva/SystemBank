package com.example.systembank.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public ResponseEntity<Pessoa> cadastrarPessoa(@Validated @RequestBody Pessoa pessoa, BindingResult result) throws Exception{
		Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();
		return pessoaSalva != null ? ResponseEntity.created(uri).body(pessoaSalva) : ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Houve uma execeção, favor verificar se há inconsistências nos valores enviados");
    }
}
