package br.gov.incra.sagra.testes.entidades;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteSuperintendenciaRegional10.class, TesteSuperintendenciaRegional13.class })
public class TesteUnidadeFederativa {

	@Fixture private SuperintendenciaRegional sr10;
	@Fixture private SuperintendenciaRegional sr13;

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(sr10, sr13);
	}

}
