package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteDocumento {

	@Fixture private Entidade entidade;

	@Test
	public void testar() throws Exception {
		Documento<Entidade> documento = new Documento<>("1", entidade);
		assertEquals("1", documento.identificador());
		assertEquals(entidade, documento.entidade());
	}

}
