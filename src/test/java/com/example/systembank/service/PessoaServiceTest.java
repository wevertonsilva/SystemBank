package com.example.systembank.service;

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
import com.example.systembank.repository.PessoaRepository;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {
	
	@InjectMocks
	private PessoaService service;
	
	@Mock
	private PessoaRepository repository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListarPessoas() {
		List<Pessoa> result = service.listarPessoas();
		System.out.println(result);
		assertNotNull(result);
	}
	
	@Test
	public void testSalvarPessoa() throws Exception {
		Conta conta = new Conta(1l, 234566l, 1234, TipoContaEnum.C, null, null, null);
		Pessoa pessoa = new Pessoa(1l,"pessoaTeste",TipoPessoaEnum.PF, 12345678976l, 9, conta);
		service.salvarPessoa(pessoa);
		verify(repository, times(1)).save(pessoa);
	}
	
	@Test(expected=Exception.class)
	public void testValidarDocumentoPF() throws Exception {
		Conta conta = new Conta(1l, 234566l, 1234, TipoContaEnum.C, null, null, null);
		Pessoa pessoa = new Pessoa(1l,"pessoaTeste",TipoPessoaEnum.PF, 1234567897689l, 9, conta);
		service.validar(pessoa);
	}
	
	@Test(expected=Exception.class)
	public void testValidarDocumentoPJ() throws Exception {
		Conta conta = new Conta(1l, 234566l, 1234, TipoContaEnum.C, null, null, null);
		Pessoa pessoa = new Pessoa(1l,"pessoaTeste",TipoPessoaEnum.PJ, 12345678976l, 9, conta);
		service.validar(pessoa);
	}
	
	@Test(expected=Exception.class)
	public void testValidarScore() throws Exception {
		Conta conta = new Conta(1l, 234566l, 1234, TipoContaEnum.C, null, null, null);
		Pessoa pessoa = new Pessoa(1l,"pessoaTeste",TipoPessoaEnum.PF, 12345678976l, 10, conta);
		service.validar(pessoa);
	}
	
}
