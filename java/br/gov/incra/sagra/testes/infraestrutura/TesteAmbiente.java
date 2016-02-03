package br.gov.incra.sagra.testes.infraestrutura;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;
import br.gov.incra.sagra.auxiliar.GeradorDeIdentificadorInteiroSequencial;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class TesteAmbiente {

	private GeradorDeIdentificador gerador;
	private Ambiente ambienteDeTeste;

	@Before
	public void configurar() {
		gerador = new GeradorDeIdentificadorInteiroSequencial();
		ambienteDeTeste = new Ambiente(gerador);
	}
	
	@Test
	public void testar() throws Exception {
		assertEquals(gerador, ambienteDeTeste.obterGeradorDeIdentificador());
	}

}
