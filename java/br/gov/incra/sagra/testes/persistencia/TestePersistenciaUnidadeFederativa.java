package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.testes.entidades.TesteMatoGrosso;
import br.gov.incra.sagra.testes.entidades.TesteSantaCatarina;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteSantaCatarina.class, TesteMatoGrosso.class })
public class TestePersistenciaUnidadeFederativa {

	@Fixture private Ambiente ambienteDeTeste;
	@Fixture private UnidadeFederativa matoGrosso;
	@Fixture private UnidadeFederativa santaCatarina;

	private PersistenciaUnidadeFederativa persistencia;
	private OperacaoDePersistencia<String> operacao;

	@Before
	public void configurar() {
		persistencia = new PersistenciaUnidadeFederativa(ambienteDeTeste);
		operacao = persistencia.cadastrar(santaCatarina);
	}

	@Test
	public void cadastrar() throws Exception {
		assertEquals("1", operacao.obterValor());
	}

	@Test
	public void cadastrarDois() throws Exception {
		OperacaoDePersistencia<String> operacaoDois = persistencia.cadastrar(matoGrosso);
		assertEquals("2", operacaoDois.obterValor());
	}

	@Test
	public void cadastrarJaCadastrado() throws Exception {
		OperacaoDePersistencia<String> operacaoRepetida = persistencia.cadastrar(santaCatarina);
		assertFalse(operacaoRepetida.sucesso());
	}

}
