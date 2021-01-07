package com.example.systembank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.systembank.constante.Constantes;
import com.example.systembank.entity.CartaoCredito;
import com.example.systembank.entity.Conta;
import com.example.systembank.entity.Pessoa;
import com.example.systembank.enuns.TipoContaEnum;
import com.example.systembank.enuns.TipoPessoaEnum;
import com.example.systembank.repository.ContaRepository;

@Component
public class ContaService {

	private final static Integer agencia = 1234;
	
	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private CartaoCreditoService cartaoCreditoService;
	
	public List<Conta> listarContas(){
		return repository.findAll();
	}
	
	public Conta criarConta(Pessoa pessoa) {
		Conta conta = new Conta();
		conta.setNumero(geraNumeroConta());
		conta.setAgencia(agencia);
		
		if(pessoa.getTipoPessoa() == TipoPessoaEnum.PF) {
			conta.setTipo(TipoContaEnum.C);
		} else {
			conta.setTipo(TipoContaEnum.E);
		}
		
		CartaoCredito cartao = calculaChequeEspecial(pessoa.getScore(), conta);
		conta.setCartao(cartao);
		
		return conta;
	}

	public Long geraNumeroConta() {
		Long numeroConta = (long) (100000l + Math.random() * 899999l);
		return numeroConta;
	}
	
	public CartaoCredito calculaChequeEspecial(Integer score, Conta conta) {
		if(score == 0 || score == 1) {
			conta.setMessage("Cheque especial desabilitado");
			return null;
		} else if(score >= 2 && score <= 5) {
			conta.setChequeEspecial(Constantes.CHEQUE_ESPECIAL_2_5);
		} else if(score >= 6 && score <= 8) {
			conta.setChequeEspecial(Constantes.CHEQUE_ESPECIAL_6_8);
		} else {
			conta.setChequeEspecial(Constantes.CHEQUE_ESPECIAL_9);
		}
		
		return cartaoCreditoService.criarCartaoCredito(conta);
	}
	
}
