package br.gov.incra.sagra.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.UnidadeFederativa;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteSantaCatarina.class, TesteMatoGrosso.class })
public class TesteSuperintendenciaRegional {

	@Fixture private UnidadeFederativa santaCatarina;
	@Fixture private UnidadeFederativa matoGrosso;

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(santaCatarina, matoGrosso);
	}

}
