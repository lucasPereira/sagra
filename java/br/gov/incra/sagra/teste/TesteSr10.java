package br.gov.incra.sagra.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.SuperIntendenciaRegional;
import br.gov.incra.sagra.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteSantaCatarina.class)
public class TesteSr10 {

	@Fixture private UnidadeFederativa santaCatarina;

	private SuperIntendenciaRegional sr10;

	@Before
	public void configurar() {
		sr10 = new SuperIntendenciaRegional("SR-10", santaCatarina);
	}

	@Test
	public void testar() throws Exception {
		assertEquals("SR-10", sr10.obterNome());
		assertEquals(santaCatarina, sr10.obterUnidadeFederativa());
	}

	@Test
	public void igualdade() throws Exception {
		SuperIntendenciaRegional sr10Clone = new SuperIntendenciaRegional("SR-10", santaCatarina);
		assertEquals(sr10, sr10Clone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SR-10", sr10.toString());
	}

}
