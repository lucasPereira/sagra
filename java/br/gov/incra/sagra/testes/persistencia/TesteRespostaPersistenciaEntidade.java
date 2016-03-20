package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteDocumento.class)
public class TesteRespostaPersistenciaEntidade {

	@Fixture private Documento<Entidade> documentoEntidade1;

	@Test
	public void sucesso() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = new RespostaPersistenciaEntidade<>(documentoEntidade1);
		assertTrue(resposta.sucesso());
		assertEquals(documentoEntidade1, resposta.documento());
		assertNotNull(documentoEntidade1);
	}

	@Test
	public void fracasso() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = new RespostaPersistenciaEntidade<>();
		assertFalse(resposta.sucesso());
		assertNull(resposta.documento());
	}

}
