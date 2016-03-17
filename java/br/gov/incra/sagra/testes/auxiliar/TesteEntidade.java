package br.gov.incra.sagra.testes.auxiliar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;

public class TesteEntidade {

	private Entidade entidade;

	@Before
	public void configurar() {
		entidade = new Entidade("Nome");
	}

	@Test
	public void entidade() throws Exception {
		assertEquals("Nome", entidade.obterNome());
	}

	@Test
	public void iguais() throws Exception {
		assertEquals(new Entidade("Nome"), entidade);
	}

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(new Entidade("Emon"), entidade);
	}

}
