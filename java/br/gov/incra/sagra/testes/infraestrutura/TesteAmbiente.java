package br.gov.incra.sagra.testes.infraestrutura;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.infraestrutura.Ambiente;

public class TesteAmbiente {

	protected Ambiente ambiente;

	@Before
	public void configurar() {
		ambiente = new Ambiente();
		ambiente.iniciarPersistencia();
	}

	@Test
	public void testar() throws Exception {
		assertEquals("http://localhost:5984/sagra", ambiente.persistenciaNome());
	}

}
