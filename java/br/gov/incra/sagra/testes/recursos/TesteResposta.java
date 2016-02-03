package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.Resposta;

public class TesteResposta {

	@Test
	public void codigoDeEstado201() throws Exception {
		Resposta<String> resposta = new Resposta<>(CodigoDeEstado.HTTP201, "/recurso/", "Entidade");
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals("/recurso/", resposta.localizacao());
		assertEquals("Entidade", resposta.entidade());
	}

}
