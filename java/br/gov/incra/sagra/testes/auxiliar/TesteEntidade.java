package br.gov.incra.sagra.testes.auxiliar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;

public class TesteEntidade {

	private Entidade entidade1;
	private Entidade entidade2;

	@Before
	public void configurar() {
		entidade1 = new Entidade("Entidade 1");
		entidade2 = new Entidade("Entidade 2");
	}

	@Test
	public void entidade() throws Exception {
		assertEquals("Entidade 1", entidade1.obterNome());
		assertEquals("Entidade 2", entidade2.obterNome());
	}

	@Test
	public void iguais() throws Exception {
		assertEquals(new Entidade("Entidade 1"), entidade1);
		assertEquals(new Entidade("Entidade 2"), entidade2);
	}

	@Test
	public void diferentes() throws Exception {
		assertNotEquals(entidade1, entidade2);
	}

}
