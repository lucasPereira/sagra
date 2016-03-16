package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;
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
	private OperacaoDePersistencia<String> operacaoCadastrarSr10;

	@Before
	public void configurar() {
		persistencia = ambiente.persistenciaSuperintendenciaRegional();
		operacaoCadastrarSr10 = persistencia.cadastrar(sr10);
	}

	@Test
	public void cadastrarSr10() throws Exception {
		assertEquals("1", operacaoCadastrarSr10.obterResultado());
	}

	@Test
	public void cadastrarSr13() throws Exception {
		assertEquals("2", persistencia.cadastrar(sr13).obterResultado());
	}

	@Test
	public void cadastrarSr10Repetida() throws Exception {
		assertEquals("2", persistencia.cadastrar(sr10).obterResultado());
	}

}
