package br.gov.incra.sagra.auxiliar;

public class Entidade {

	private String nome;

	public Entidade(String nome) {
		this.nome = nome;
	}

	public String obterNome() {
		return nome;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Entidade) {
			Entidade outro = (Entidade) objeto;
			return nome.equals(outro.nome);
		}
		return false;
	}

}
