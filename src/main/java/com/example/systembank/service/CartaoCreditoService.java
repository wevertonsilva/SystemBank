package com.example.systembank.service;

import org.springframework.stereotype.Component;

import com.example.systembank.constante.Constantes;
import com.example.systembank.entity.CartaoCredito;
import com.example.systembank.entity.Conta;

@Component
public class CartaoCreditoService {
	
	public CartaoCredito criarCartaoCredito(Conta conta) {
		CartaoCredito cartao = new CartaoCredito();
		
		if(conta.getChequeEspecial().compareTo(Constantes.CHEQUE_ESPECIAL_2_5) == 0) {
			cartao.setLimiteCredito(Constantes.CARTAO_CREDITO_2_5);
		} else if (conta.getChequeEspecial().compareTo(Constantes.CHEQUE_ESPECIAL_6_8) == 0) {
			cartao.setLimiteCredito(Constantes.CARTAO_CREDITO_6_8);
		} else {
			cartao.setLimiteCredito(Constantes.CARTAO_CREDITO_9);
		}
		
		return cartao;
	}

}
