package br.gov.incra.sagra.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.SuperintendenciaRegional;
import br.gov.incra.sagra.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteMatoGrosso.class)
public class TesteSr13 {

	@Fixture private UnidadeFederativa matoGrosso;

	private SuperintendenciaRegional sr13;

	@Before
	public void configurar() {
		sr13 = new SuperintendenciaRegional("SR-13", matoGrosso);
	}

	@Test
	public void testar() throws Exception {
		assertEquals("SR-13", sr13.obterNome());
		assertEquals(matoGrosso, sr13.obterUnidadeFederativa());
	}

	@Test
	public void igualdade() throws Exception {
		SuperintendenciaRegional sr10Clone = new SuperintendenciaRegional("SR-13", matoGrosso);
		assertEquals(sr13, sr10Clone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SR-13", sr13.toString());
	}

}
