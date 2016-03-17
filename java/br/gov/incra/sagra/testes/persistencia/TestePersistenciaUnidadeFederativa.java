package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.persistencia.RespostaPersistencia;
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
	public void cadastrarSantaCatarina() throws Exception {
		RespostaPersistencia<?> resposta = persistencia.cadastrar(santaCatarina);
		assertTrue(resposta.sucesso());
		assertEquals("1", resposta.documento().identificador());
		assertEquals(santaCatarina, resposta.documento().entidade());
	}

	@Test
	public void cadastrarMatoGrosso() throws Exception {
		persistencia.cadastrar(santaCatarina);
		RespostaPersistencia<?> resposta = persistencia.cadastrar(matoGrosso);
		assertTrue(resposta.sucesso());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(matoGrosso, resposta.documento().entidade());
	}

	@Test
	public void cadastrarSantaCatarinaRepetida() throws Exception {
		persistencia.cadastrar(santaCatarina);
		RespostaPersistencia<?> resposta = persistencia.cadastrar(santaCatarina);
		assertTrue(resposta.sucesso());
		assertEquals("2", resposta.documento().identificador());
		assertEquals(santaCatarina, resposta.documento().entidade());
	}

}
