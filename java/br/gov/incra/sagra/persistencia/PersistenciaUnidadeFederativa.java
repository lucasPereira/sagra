package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaUnidadeFederativa implements Persistencia<UnidadeFederativa> {

	private Ambiente ambiente;
	private List<Documento<UnidadeFederativa>> docuentos;

	public PersistenciaUnidadeFederativa(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.docuentos = new LinkedList<>();
	}

	@Override
	public RespostaPersistencia<UnidadeFederativa> cadastrar(UnidadeFederativa entidade) {
		String identificador = ambiente.auxiliarGeradorDeIdentificador().gerar();
		RespostaPersistencia<UnidadeFederativa> resposta = new RespostaPersistencia<>(identificador, entidade);
		docuentos.add(resposta.documento());
		return resposta;
	}

}
