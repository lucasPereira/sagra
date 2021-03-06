package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteUnidadeFederativaSantaCatarina.class, TesteUnidadeFederativaMatoGrosso.class })
public class TesteSuperintendenciaRegional10 {

	@Fixture private UnidadeFederativa santaCatarina;
	@Fixture private UnidadeFederativa matoGrosso;

	private SuperintendenciaRegional sr10;

	@Before
	public void configurar() {
		sr10 = new SuperintendenciaRegional("SR-10", santaCatarina);
	}

	@Test
	public void entidade() throws Exception {
		assertEquals("SR-10", sr10.obterNome());
		assertEquals(santaCatarina, sr10.obterUnidadeFederativa());
	}

	@Test
	public void iguais() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-10", santaCatarina);
		assertEquals(sr10, clone);
	}

	@Test
	public void nomesDiferentes() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-13", santaCatarina);
		assertNotEquals(sr10, clone);
	}

	@Test
	public void unidadesFederativasDiferentes() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-10", matoGrosso);
		assertNotEquals(sr10, clone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SR-10", sr10.toString());
	}

}
