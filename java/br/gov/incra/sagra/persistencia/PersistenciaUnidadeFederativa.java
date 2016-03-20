package br.gov.incra.sagra.persistencia;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaUnidadeFederativa implements Persistencia<UnidadeFederativa> {

	private Ambiente ambiente;
	private List<Documento<UnidadeFederativa>> documentos;

	public PersistenciaUnidadeFederativa(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.documentos = new LinkedList<>();
	}

	@Override
	public RespostaPersistenciaEntidade<UnidadeFederativa> cadastrar(UnidadeFederativa entidade) {
		RespostaPersistenciaEntidade<UnidadeFederativa> resposta = new Persistidor<UnidadeFederativa>().cadastrar(ambiente, entidade);
		documentos.add(resposta.documento());
		return resposta;
	}

	@Override
	public RespostaPersistenciaColecao<UnidadeFederativa> listar() {
		Collections.sort(documentos, new Comparator<Documento<UnidadeFederativa>>() {

			@Override
			public int compare(Documento<UnidadeFederativa> documento1, Documento<UnidadeFederativa> documento2) {
				return documento1.entidade().obterSigla().compareTo(documento2.entidade().obterSigla());
			}

		});
		return new RespostaPersistenciaColecao<>(documentos);
	}

}
