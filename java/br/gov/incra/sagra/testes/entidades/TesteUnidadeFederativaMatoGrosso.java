package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;

public class TesteUnidadeFederativaMatoGrosso {

	private UnidadeFederativa matoGrosso;

	@Before
	public void configurar() {
		matoGrosso = new UnidadeFederativa("Mato Grosso", "MT");
	}

	@Test
	public void entidade() throws Exception {
		assertEquals("Mato Grosso", matoGrosso.obterNome());
		assertEquals("MT", matoGrosso.obterSigla());
	}

	@Test
	public void iguais() throws Exception {
		UnidadeFederativa matoGrossoClone = new UnidadeFederativa("Mato Grosso", "MT");
		assertEquals(matoGrosso, matoGrossoClone);
	}

	@Test
	public void nomesDiferentes() throws Exception {
		UnidadeFederativa matoGrossoClone = new UnidadeFederativa("Santa Catarina", "MT");
		assertNotEquals(matoGrosso, matoGrossoClone);
	}

	@Test
	public void siglasDiferentes() throws Exception {
		UnidadeFederativa matoGrossoClone = new UnidadeFederativa("Mato Grosso", "SC");
		assertNotEquals(matoGrosso, matoGrossoClone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("MT", matoGrosso.toString());
	}

}
