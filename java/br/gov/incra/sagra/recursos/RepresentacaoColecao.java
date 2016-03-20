package br.gov.incra.sagra.recursos;

import java.util.List;

public class RepresentacaoColecao<T> implements Representacao {

	private String uri;
	private List<RepresentacaoEntidade<T>> representacoes;

	public RepresentacaoColecao(String uri, List<RepresentacaoEntidade<T>> representacoes) {
		this.uri = uri;
		this.representacoes = representacoes;
	}

	@Override
	public String uri() {
		return uri;
	}

	public int tamanho() {
		return representacoes.size();
	}

	public RepresentacaoEntidade<T> representacao(Integer indice) {
		return representacoes.get(indice);
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof RepresentacaoColecao) {
			RepresentacaoColecao<?> outro = (RepresentacaoColecao<?>) objeto;
			Boolean uriIgual = uri.equals(outro.uri);
			Boolean representacoesIgual = representacoes.equals(outro.representacoes);
			return uriIgual && representacoesIgual;
		}
		return super.equals(objeto);
	}

}
