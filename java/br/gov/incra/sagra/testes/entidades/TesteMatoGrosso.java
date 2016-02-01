package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;

public class TesteMatoGrosso {

	private UnidadeFederativa matoGrosso;

	@Before
	public void configurar() {
		matoGrosso = new UnidadeFederativa("Mato Grosso", "MT");
	}

	@Test
	public void testar() throws Exception {
		assertEquals("Mato Grosso", matoGrosso.obterNome());
		assertEquals("MT", matoGrosso.obterSigla());
	}

	@Test
	public void igualdade() throws Exception {
		UnidadeFederativa matoGrossoClone = new UnidadeFederativa("Mato Grosso", "MT");
		assertEquals(matoGrosso, matoGrossoClone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("MT", matoGrosso.toString());
	}

}
