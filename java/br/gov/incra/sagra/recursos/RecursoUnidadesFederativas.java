package br.gov.incra.sagra.recursos;

import java.util.ArrayList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaColecao;
import br.gov.incra.sagra.persistencia.RespostaPersistenciaEntidade;

public class RecursoUnidadesFederativas {

	private Ambiente ambiente;

	public RecursoUnidadesFederativas(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public RespostaRecurso<RepresentacaoEntidade<UnidadeFederativa>> post(String nome, String sigla) {
		FabricaUnidadeFederativa fabrica = new FabricaUnidadeFederativa();
		fabrica.comNome(nome);
		fabrica.comSigla(sigla);
		if (!fabrica.validarDados()) {
			return new RespostaRecurso<>(CodigoDeEstado.HTTP400);
		}
		RespostaPersistenciaEntidade<UnidadeFederativa> resposta = ambiente.persistenciaUnidadeFederativa().cadastrar(fabrica.construir());
		Documento<UnidadeFederativa> documento = resposta.documento();
		String uri = String.format("/unidadeFederativa/%s", documento.identificador());
		UnidadeFederativa entidade = documento.entidade();
		RepresentacaoEntidade<UnidadeFederativa> representacao = new RepresentacaoEntidade<>(uri, entidade);
		return new RespostaRecurso<>(CodigoDeEstado.HTTP201, representacao);
	}

	public RespostaRecurso<RepresentacaoColecao<UnidadeFederativa>> get() {
		RespostaPersistenciaColecao<UnidadeFederativa> resposta = ambiente.persistenciaUnidadeFederativa().listar();
		Integer tamanho = resposta.tamanho();
		List<RepresentacaoEntidade<UnidadeFederativa>> representacoes = new ArrayList<>(tamanho);
		for (Integer contador = 0; contador < tamanho; contador++) {
			Documento<UnidadeFederativa> documento = resposta.documento(contador);
			String uri = String.format("/unidadeFederativa/%s", documento.identificador());
			RepresentacaoEntidade<UnidadeFederativa> representacao = new RepresentacaoEntidade<UnidadeFederativa>(uri, documento.entidade());
			representacoes.add(representacao);
		}
		RepresentacaoColecao<UnidadeFederativa> representacao = new RepresentacaoColecao<>("/unidadesFederativas", representacoes);
		return new RespostaRecurso<>(CodigoDeEstado.HTTP200, representacao);
	}

}
