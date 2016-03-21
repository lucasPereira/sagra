package br.gov.incra.sagra.testes.auxiliar;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteAmbiente.class)
public class TesteGeradorDeIdentificador {

	@Fixture private Ambiente ambiente;

	@Test
	public void testar() throws Exception {
		assertEquals("1", ambiente.geradorDeIdentificador().gerar());
		assertEquals("2", ambiente.geradorDeIdentificador().gerar());
	}

}
