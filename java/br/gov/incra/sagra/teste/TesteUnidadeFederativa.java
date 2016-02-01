package br.gov.incra.sagra.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.SuperintendenciaRegional;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteSr10.class, TesteSr13.class })
public class TesteUnidadeFederativa {

	@Fixture private SuperintendenciaRegional sr10;
	@Fixture private SuperintendenciaRegional sr13;

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(sr10, sr13);
	}

}
