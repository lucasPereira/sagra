package br.gov.incra.sagra.auxiliar;

public class GeradorDeIdentificadorInteiroSequencial implements GeradorDeIdentificador {

	private Integer contador;

	public GeradorDeIdentificadorInteiroSequencial() {
		contador = 0;
	}

	@Override
	public String gerar() {
		contador++;
		return contador.toString();
	}

}
