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
	public void comCodigoDeEstadoEntidade() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = new RespostaPersistenciaEntidade<>(201, documentoEntidade1);
		assertTrue(resposta.semExcecao());
		assertEquals(201, resposta.codigoDeEstado().intValue());
		assertEquals(documentoEntidade1, resposta.documento());
		assertNotNull(documentoEntidade1);
	}

	@Test
	public void comCodigoDeEstadoSemEntidade() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = new RespostaPersistenciaEntidade<>(404);
		assertTrue(resposta.semExcecao());
		assertEquals(404, resposta.codigoDeEstado().intValue());
		assertNull(resposta.documento());
	}

	@Test
	public void semCodigoDeEstadoSemEntidade() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = new RespostaPersistenciaEntidade<>();
		assertFalse(resposta.semExcecao());
		assertNull(resposta.codigoDeEstado());
		assertNull(resposta.documento());
	}

}
