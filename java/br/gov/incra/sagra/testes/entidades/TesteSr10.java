package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteSantaCatarina.class)
public class TesteSr10 {

	@Fixture private UnidadeFederativa santaCatarina;

	private SuperintendenciaRegional sr10;

	@Before
	public void configurar() {
		sr10 = new SuperintendenciaRegional("SR-10", santaCatarina);
	}

	@Test
	public void testar() throws Exception {
		assertEquals("SR-10", sr10.obterNome());
		assertEquals(santaCatarina, sr10.obterUnidadeFederativa());
	}

	@Test
	public void igualdade() throws Exception {
		SuperintendenciaRegional sr10Clone = new SuperintendenciaRegional("SR-10", santaCatarina);
		assertEquals(sr10, sr10Clone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SR-10", sr10.toString());
	}

}
