package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.persistencia.Registro;
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
	private OperacaoDePersistencia<String> operacaoCadastrarSantaCatarina;

	@Before
	public void configurar() {
		persistencia = ambiente.persistenciaUnidadeFederativa();
		operacaoCadastrarSantaCatarina = persistencia.cadastrar(santaCatarina);
	}

	@Test
	public void cadastrarSantaCatarina() throws Exception {
		assertEquals("1", operacaoCadastrarSantaCatarina.obterResultado());
	}

	@Test
	public void cadastrarMatoGrosso() throws Exception {
		assertEquals("2", persistencia.cadastrar(matoGrosso).obterResultado());
	}

	@Test
	public void cadastrarSantaCatarinaRepetida() throws Exception {
		assertEquals("2", persistencia.cadastrar(santaCatarina).obterResultado());
	}

	@Test
	public void listar() throws Exception {
		List<Registro<UnidadeFederativa>> resultado = persistencia.listar().obterResultado();
		assertEquals(1, resultado.size());
		assertEquals("1", resultado.get(0).obterIdentificador());
		assertEquals(santaCatarina, resultado.get(0).obterEntidade());
	}

}
