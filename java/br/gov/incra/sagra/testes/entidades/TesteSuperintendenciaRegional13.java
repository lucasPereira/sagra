package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteUnidadeFederativaMatoGrosso.class, TesteUnidadeFederativaSantaCatarina.class })
public class TesteSuperintendenciaRegional13 {

	@Fixture private UnidadeFederativa matoGrosso;
	@Fixture private UnidadeFederativa santaCatarina;

	private SuperintendenciaRegional sr13;

	@Before
	public void configurar() {
		sr13 = new SuperintendenciaRegional("SR-13", matoGrosso);
	}

	@Test
	public void entidade() throws Exception {
		assertEquals("SR-13", sr13.obterNome());
		assertEquals(matoGrosso, sr13.obterUnidadeFederativa());
	}

	@Test
	public void iguais() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-13", matoGrosso);
		assertEquals(sr13, clone);
	}

	@Test
	public void nomesDiferentes() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-10", matoGrosso);
		assertNotEquals(sr13, clone);
	}

	@Test
	public void unidadesFederativasDiferentes() throws Exception {
		SuperintendenciaRegional clone = new SuperintendenciaRegional("SR-13", santaCatarina);
		assertNotEquals(sr13, clone);
	}

	@Test
	public void valorTextual() throws Exception {
		assertEquals("SR-13", sr13.toString());
	}

}
