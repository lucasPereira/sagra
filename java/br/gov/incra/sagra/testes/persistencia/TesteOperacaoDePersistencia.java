package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;

public class TesteOperacaoDePersistencia {

	@Test
	public void sucesso10() throws Exception {
		OperacaoDePersistencia<Integer> operacao = new OperacaoDePersistencia<>(10);
		assertTrue(operacao.sucesso());
		assertEquals(new Integer(10), operacao.obterResultado());
	}

	@Test
	public void sucessoDez() throws Exception {
		OperacaoDePersistencia<String> operacao = new OperacaoDePersistencia<>("Dez");
		assertTrue(operacao.sucesso());
		assertEquals("Dez", operacao.obterResultado());
	}

	@Test
	public void fracasso() throws Exception {
		OperacaoDePersistencia<String> operacao = new OperacaoDePersistencia<>();
		assertFalse(operacao.sucesso());
		assertNull(operacao.obterResultado());
	}

}
