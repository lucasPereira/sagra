package br.gov.incra.sagra.infraestrutura;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;

public class Ambiente {

	private GeradorDeIdentificador gerador;

	public Ambiente(GeradorDeIdentificador gerador) {
		this.gerador = gerador;
	}

	public GeradorDeIdentificador obterGeradorDeIdentificador() {
		return gerador;
	}

}
