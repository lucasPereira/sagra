package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;

public class TesteSantaCatarina {

	private UnidadeFederativa santaCatarina;

	@Before
	public void configurar() {
		santaCatarina = new UnidadeFederativa("Santa Catarina", "SC");
	}

	@Test
	public void testar() throws Exception {
		assertEquals("Santa Catarina", santaCatarina.obterNome());
		assertEquals("SC", santaCatarina.obterSigla());
	}

	@Test
	public void igualdade() {
		UnidadeFederativa santaCatarinaClone = new UnidadeFederativa("Santa Catarina", "SC");
		assertEquals(santaCatarina, santaCatarinaClone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SC", santaCatarina.toString());
	}

}
