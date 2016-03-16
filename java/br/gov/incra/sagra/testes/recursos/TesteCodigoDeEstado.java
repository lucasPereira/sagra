package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.recursos.CodigoDeEstado;

public class TesteCodigoDeEstado {

	@Test
	public void testar() throws Exception {
		assertEquals(3, CodigoDeEstado.values().length);
		assertEquals(CodigoDeEstado.HTTP200, CodigoDeEstado.values()[0]);
		assertEquals(CodigoDeEstado.HTTP201, CodigoDeEstado.values()[1]);
		assertEquals(CodigoDeEstado.HTTP400, CodigoDeEstado.values()[2]);
	}

}
