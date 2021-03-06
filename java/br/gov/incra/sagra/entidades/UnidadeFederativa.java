package br.gov.incra.sagra.entidades;

public class UnidadeFederativa {

	private String nome;
	private String sigla;

	public UnidadeFederativa(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String obterNome() {
		return nome;
	}

	public String obterSigla() {
		return sigla;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto != null && objeto instanceof UnidadeFederativa) {
			UnidadeFederativa outro = (UnidadeFederativa) objeto;
			Boolean nomeIgual = nome.equals(outro.nome);
			Boolean siglaIgual = sigla.equals(outro.sigla);
			return nomeIgual && siglaIgual;
		}
		return super.equals(objeto);
	}

	@Override
	public String toString() {
		return sigla;
	}

}
