package br.gov.incra.sagra.fabricas;

import java.util.regex.Pattern;

import br.gov.incra.sagra.entidades.UnidadeFederativa;

public class FabricaUnidadeFederativa {

	private String nome;
	private String sigla;
	private Boolean dadosValidos;

	public FabricaUnidadeFederativa() {
		dadosValidos = true;
	}

	public Boolean validarDados() {
		return dadosValidos && (nome != null) && (sigla != null);
	}

	public UnidadeFederativa construir() {
		return new UnidadeFederativa(nome, sigla);
	}

	public void comNome(String nome) {
		dadosValidos = dadosValidos && Pattern.compile("\\p{L}{1,32}( \\p{L}{1,32}){0,8}").matcher(nome).matches();
		this.nome = nome;
	}

	public void comSigla(String sigla) {
		dadosValidos = dadosValidos && Pattern.compile("[A-Z]{2}").matcher(sigla).matches();
		this.sigla = sigla;
	}

}
