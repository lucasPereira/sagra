package br.gov.incra.sagra.testes.auxiliar;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;
import br.gov.incra.sagra.auxiliar.GeradorDeIdentificadorInteiroSequencial;

public class TesteGeradorDeIdentificador {

	@Test
	public void inteiroSequencial() throws Exception {
		GeradorDeIdentificador gerador = new GeradorDeIdentificadorInteiroSequencial();
		assertEquals("1", gerador.gerar());
		assertEquals("2", gerador.gerar());
	}

}
