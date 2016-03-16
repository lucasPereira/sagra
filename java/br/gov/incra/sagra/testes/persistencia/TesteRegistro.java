package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.persistencia.Registro;

public class TesteRegistro {

	@Test
	public void testar() throws Exception {
		Registro<String> registro = new Registro<>("1", "Entidade");
		assertEquals("1", registro.obterIdentificador());
		assertEquals("Entidade", registro.obterEntidade());
	}

}
