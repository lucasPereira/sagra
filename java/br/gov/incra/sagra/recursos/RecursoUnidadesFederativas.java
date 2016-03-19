package br.gov.incra.sagra.recursos;

import java.util.Arrays;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.persistencia.RespostaPersistencia;

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
		RespostaPersistencia<UnidadeFederativa> persistencia = ambiente.persistenciaUnidadeFederativa().cadastrar(fabrica.construir());
		Documento<UnidadeFederativa> documento = persistencia.documento();
		String uri = String.format("/unidadeFederativa/%s", documento.identificador());
		UnidadeFederativa entidade = documento.entidade();
		RepresentacaoEntidade<UnidadeFederativa> representacao = new RepresentacaoEntidade<>(uri, entidade);
		return new RespostaRecurso<>(CodigoDeEstado.HTTP201, representacao);
	}

	public RespostaRecurso<RepresentacaoColecao<UnidadeFederativa>> get() {
		RepresentacaoColecao<UnidadeFederativa> representacao = new RepresentacaoColecao<>("/unidadesFederativas", Arrays.asList());
		return new RespostaRecurso<>(CodigoDeEstado.HTTP200, representacao);
	}

}
