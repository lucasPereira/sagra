package br.gov.incra.sagra.recursos;

public class RepresentacaoEntidade<T> implements Representacao {

	private String uri;
	private T entidade;

	public RepresentacaoEntidade(String uri, T entidade) {
		this.uri = uri;
		this.entidade = entidade;
	}

	@Override
	public String uri() {
		return uri;
	}

	public T entidade() {
		return entidade;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof RepresentacaoEntidade) {
			RepresentacaoEntidade<?> outro = (RepresentacaoEntidade<?>) objeto;
			return uri.equals(outro.uri) && entidade.equals(outro.entidade);
		}
		return super.equals(objeto);
	}

}
