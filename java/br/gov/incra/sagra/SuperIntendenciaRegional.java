package br.gov.incra.sagra;

public class SuperIntendenciaRegional {

	private String nome;
	private UnidadeFederativa unidadeFederativa;

	public SuperIntendenciaRegional(String nome, UnidadeFederativa unidadeFederativa) {
		this.nome = nome;
		this.unidadeFederativa = unidadeFederativa;
	}

	public String obterNome() {
		return nome;
	}

	public UnidadeFederativa obterUnidadeFederativa() {
		return unidadeFederativa;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof SuperIntendenciaRegional) {
			SuperIntendenciaRegional outro = (SuperIntendenciaRegional) objeto;
			return nome.equals(outro.nome);
		}
		return false;
	}

	@Override
	public String toString() {
		return nome;
	}

}
