package com.example.systembank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.systembank.entity.Conta;
import com.example.systembank.entity.Pessoa;
import com.example.systembank.enuns.TipoContaEnum;
import com.example.systembank.enuns.TipoPessoaEnum;
import com.example.systembank.repository.ContaRepository;
import com.example.systembank.repository.PessoaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContaServiceTest {
	
	@InjectMocks
	private ContaService service;
	
	@Mock
	private ContaRepository repository;
	
	@Mock
	private CartaoCreditoService cartaoService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListarContas() {
		List<Conta> result = service.listarContas();
		System.out.println(result);
		assertNotNull(result);
	}

	@Test
	public void testCriarConta() {
		Pessoa pessoa = new Pessoa(1l,"pessoaTeste",TipoPessoaEnum.PF, 12345678976l, 9, null);
		Conta result = service.criarConta(pessoa);
		System.out.println(result);
		assertNotNull(result);
	}
	
	@Test
	public void testGerarNumeroConta() {
		Long numeroConta = service.geraNumeroConta();
		assertEquals(6l, (long) String.valueOf(numeroConta).length());
	}
	
}
