package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.auxiliar.Limbo;
import br.gov.incra.sagra.persistencia.RespostaPersistencia;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteRespostaPersistencia {

	@Fixture private Entidade entidade;

	@Test
	public void sucessoComEntidade() throws Exception {
		RespostaPersistencia<?> resposta = new RespostaPersistencia<>("1", entidade);
		assertTrue(resposta.sucesso());
		assertEquals("1", resposta.documento().identificador());
		assertEquals(entidade, resposta.documento().entidade());
	}

	@Test
	public void sucessoSemEntidade() throws Exception {
		RespostaPersistencia<?> resposta = new RespostaPersistencia<>(new Limbo());
		assertTrue(resposta.sucesso());
		assertNull(resposta.documento());
	}

	@Test
	public void fracasso() throws Exception {
		RespostaPersistencia<?> resposta = new RespostaPersistencia<>();
		assertFalse(resposta.sucesso());
		assertNull(resposta.documento());
	}

}
