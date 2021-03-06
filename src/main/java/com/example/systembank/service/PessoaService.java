package com.example.systembank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.systembank.entity.Conta;
import com.example.systembank.entity.Pessoa;
import com.example.systembank.enuns.TipoPessoaEnum;
import com.example.systembank.repository.PessoaRepository;

@Component
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ContaService contaService;
	
	public List<Pessoa> listarPessoas(){
		return repository.findAll(); 
	}

	public Pessoa salvarPessoa(Pessoa pessoa) throws Exception {
		validar(pessoa);
		Conta conta = contaService.criarConta(pessoa);
		pessoa.setConta(conta);
		return repository.save(pessoa);
	}

	public void validar(Pessoa pessoa) throws Exception {
		Long documentoSize = (long) String.valueOf(pessoa.getNumeroDocumento()).length();
		if(pessoa.getTipoPessoa() == TipoPessoaEnum.PF && documentoSize != 11) {
			throw new Exception("Documento inválido, o documento deve conter 11 digitos");
		} else if(pessoa.getTipoPessoa() == TipoPessoaEnum.PJ && documentoSize != 14) {
			throw new Exception("Documento inválido, o documento deve conter 14 digitos");
		}
		
		if(pessoa.getScore() > 9 || pessoa.getScore() < 0) {
			throw new Exception("Score inválido, o score deve estar entre 0 e 9");
		}
		
		if(!pessoa.getTipoPessoa().equals(TipoPessoaEnum.PF) && !pessoa.getTipoPessoa().equals(TipoPessoaEnum.PJ)) {
			throw new Exception("Tipo Pessoa inválido, o tipo deve ser PF ou PJ");
		}
	}
	
}
