package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;
import br.gov.incra.sagra.persistencia.PersistenciaSuperintendenciaRegional;
import br.gov.incra.sagra.testes.entidades.TesteSr10;
import br.gov.incra.sagra.testes.entidades.TesteSr13;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteSr10.class, TesteSr13.class })
public class TestePersistenciaSuperintendenciaRegional {

	@Fixture private Ambiente ambiente;
	@Fixture private SuperintendenciaRegional sr10;
	@Fixture private SuperintendenciaRegional sr13;

	private OperacaoDePersistencia<String> operacao;
	private PersistenciaSuperintendenciaRegional persistencia;

	@Before
	public void configurar() {
		persistencia = ambiente.persistenciaSuperintendenciaRegional();
		operacao = persistencia.cadastrar(sr10);
	}

	@Test
	public void cadastrar() throws Exception {
		assertEquals("1", operacao.obterValor());
	}

	@Test
	public void cadastrarDois() throws Exception {
		OperacaoDePersistencia<String> operacao = persistencia.cadastrar(sr13);
		assertEquals("2", operacao.obterValor());
	}

	@Test
	public void cadastrarJaCadastrado() throws Exception {
		OperacaoDePersistencia<String> operacaoRepetida = persistencia.cadastrar(sr10);
		assertFalse(operacaoRepetida.sucesso());
	}

}
