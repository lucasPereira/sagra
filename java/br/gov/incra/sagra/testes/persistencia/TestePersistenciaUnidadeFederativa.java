package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaColecao;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaEntidade;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaMatoGrosso;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaSantaCatarina;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteUnidadeFederativaSantaCatarina.class, TesteUnidadeFederativaMatoGrosso.class })
public class TestePersistenciaUnidadeFederativa {

	@Fixture private Ambiente ambiente;
	@Fixture private UnidadeFederativa matoGrosso;
	@Fixture private UnidadeFederativa santaCatarina;

	private PersistenciaUnidadeFederativa persistencia;

	@Before
	public void configurar() {
		persistencia = ambiente.persistenciaUnidadeFederativa();
	}

	@Test
	public void cadastrarUm() throws Exception {
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(santaCatarina);
		assertTrue(resposta.sucesso());
		assertEquals("1", resposta.documento().identificador());
		assertEquals(santaCatarina, resposta.documento().entidade());
	}

	@Test
	public void cadastrarDois() throws Exception {
		persistencia.cadastrar(santaCatarina);
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(matoGrosso);
		assertTrue(resposta.sucesso());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(matoGrosso, resposta.documento().entidade());
	}

	@Test
	public void cadastrarDoisIguais() throws Exception {
		persistencia.cadastrar(santaCatarina);
		RespostaPersistenciaEntidade<?> resposta = persistencia.cadastrar(santaCatarina);
		assertTrue(resposta.sucesso());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(santaCatarina, resposta.documento().entidade());
	}

	@Test
	public void listarComZero() throws Exception {
		RespostaPersistenciaColecao<?> resposta = persistencia.listar();
		assertTrue(resposta.sucesso());
		assertEquals(0, resposta.tamanho());
	}

	@Test
	public void listarComDois() throws Exception {
		persistencia.cadastrar(santaCatarina);
		persistencia.cadastrar(matoGrosso);
		RespostaPersistenciaColecao<?> resposta = persistencia.listar();
		assertTrue(resposta.sucesso());
		assertEquals(2, resposta.tamanho());
		assertEquals("2", resposta.documento(0).identificador());
		assertEquals("1", resposta.documento(1).identificador());
		assertEquals(matoGrosso, resposta.documento(0).entidade());
		assertEquals(santaCatarina, resposta.documento(1).entidade());
	}

	@Test
	public void listarComDoisIguais() throws Exception {
		persistencia.cadastrar(santaCatarina);
		persistencia.cadastrar(santaCatarina);
		RespostaPersistenciaColecao<?> resposta = persistencia.listar();
		assertTrue(resposta.sucesso());
		assertEquals(2, resposta.tamanho());
		assertEquals("1", resposta.documento(0).identificador());
		assertEquals("2", resposta.documento(1).identificador());
		assertEquals(santaCatarina, resposta.documento(0).entidade());
		assertEquals(santaCatarina, resposta.documento(1).entidade());
	}

}
