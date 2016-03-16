package br.gov.incra.sagra.entidades;

public class SuperintendenciaRegional {

	private String nome;
	private UnidadeFederativa unidadeFederativa;

	public SuperintendenciaRegional(String nome, UnidadeFederativa unidadeFederativa) {
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
		if (objeto != null && objeto instanceof SuperintendenciaRegional) {
			SuperintendenciaRegional outro = (SuperintendenciaRegional) objeto;
			Boolean nomeIgual = nome.equals(outro.nome);
			Boolean unidadeFederativaIgual = unidadeFederativa.equals(outro.unidadeFederativa);
			return nomeIgual && unidadeFederativaIgual;
		}
		return false;
	}

	@Override
	public String toString() {
		return nome;
	}

}
