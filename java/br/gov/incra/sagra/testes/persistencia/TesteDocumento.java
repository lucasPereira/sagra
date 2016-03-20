package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteDocumento {

	@Fixture private Entidade entidade1;
	@Fixture private Entidade entidade2;

	private Documento<Entidade> documentoEntidade1;
	private Documento<Entidade> documentoEntidade2;

	@Before
	public void configurar() {
		documentoEntidade1 = new Documento<>("1", entidade1);
		documentoEntidade2 = new Documento<>("2", entidade2);
	}

	@Test
	public void documentoEntidade1() throws Exception {
		assertEquals("1", documentoEntidade1.identificador());
		assertEquals(entidade1, documentoEntidade1.entidade());
	}

	@Test
	public void documentoEntidade2() throws Exception {
		assertEquals("2", documentoEntidade2.identificador());
		assertEquals(entidade2, documentoEntidade2.entidade());
	}

	@Test
	public void iguais() throws Exception {
		Documento<Entidade> documentoEntidade1Clone = new Documento<>("1", entidade1);
		Documento<Entidade> documentoEntidade2Clone = new Documento<>("2", entidade2);
		assertEquals(documentoEntidade1Clone, documentoEntidade1);
		assertEquals(documentoEntidade2Clone, documentoEntidade2);
	}

	@Test
	public void diferentes() throws Exception {
		Documento<Entidade> documento1Entidade2 = new Documento<>("1", entidade2);
		Documento<Entidade> documento2Entidade1 = new Documento<>("2", entidade1);
		assertNotEquals(documento1Entidade2, documentoEntidade1);
		assertNotEquals(documento1Entidade2, documentoEntidade2);
		assertNotEquals(documento2Entidade1, documentoEntidade1);
		assertNotEquals(documento2Entidade1, documentoEntidade2);
		assertNotEquals(documentoEntidade1, documentoEntidade2);
	}

}
