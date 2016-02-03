package br.gov.incra.sagra.testes.infraestrutura;

import org.junit.Before;

import br.gov.incra.sagra.infraestrutura.Ambiente;

public class TesteAmbiente {

	protected Ambiente ambiente;

	@Before
	public void configurar() {
		ambiente = new Ambiente();
	}

}
