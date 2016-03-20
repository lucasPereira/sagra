package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaColecao;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteDocumento.class)
public class TesteRespostaPersistenciaColecao {

	@Fixture private Documento<Entidade> documentoEntidade1;
	@Fixture private Documento<Entidade> documentoEntidade2;

	@Test
	public void sucessoComColecaoComZero() throws Exception {
		RespostaPersistenciaColecao<?> resposta = new RespostaPersistenciaColecao<>(Arrays.asList());
		assertTrue(resposta.sucesso());
		assertEquals(0, resposta.tamanho());
	}

	@Test
	public void sucessoComColecaoComDois() throws Exception {
		RespostaPersistenciaColecao<?> resposta = new RespostaPersistenciaColecao<>(Arrays.asList(documentoEntidade1, documentoEntidade2));
		assertTrue(resposta.sucesso());
		assertEquals(2, resposta.tamanho());
		assertEquals(documentoEntidade1, resposta.documento(0));
		assertEquals(documentoEntidade2, resposta.documento(1));
		assertNotNull(documentoEntidade1);
		assertNotNull(documentoEntidade2);
	}

	@Test
	public void fracasso() throws Exception {
		RespostaPersistenciaColecao<?> resposta = new RespostaPersistenciaColecao<>();
		assertFalse(resposta.sucesso());
	}

}
