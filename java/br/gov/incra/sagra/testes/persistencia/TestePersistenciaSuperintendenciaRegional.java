package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaEntidade;
import br.gov.incra.sagra.persistencia.PersistenciaSuperintendenciaRegional;
import br.gov.incra.sagra.testes.entidades.TesteSuperintendenciaRegional10;
import br.gov.incra.sagra.testes.entidades.TesteSuperintendenciaRegional13;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteSuperintendenciaRegional10.class, TesteSuperintendenciaRegional13.class })
public class TestePersistenciaSuperintendenciaRegional {

	@Fixture private Ambiente ambiente;
	@Fixture private SuperintendenciaRegional sr10;
	@Fixture private SuperintendenciaRegional sr13;

	private PersistenciaSuperintendenciaRegional persistencia;

	@Before
	public void configurar() {
		persistencia = ambiente.persistenciaSuperintendenciaRegional();
	}

	@Test
	public void cadastrarUm() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(sr10);
		assertTrue(resposta.semExcecao());
		assertEquals("1", resposta.documento().identificador());
		assertEquals(sr10, resposta.documento().entidade());
	}

	@Test
	public void cadastrarDois() throws Exception {
		persistencia.cadastrar(sr10);
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(sr13);
		assertTrue(resposta.semExcecao());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(sr13, resposta.documento().entidade());
	}

	@Test
	public void cadastrarDoisIguais() throws Exception {
		persistencia.cadastrar(sr10);
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(sr10);
		assertTrue(resposta.semExcecao());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(sr10, resposta.documento().entidade());
	}

}
