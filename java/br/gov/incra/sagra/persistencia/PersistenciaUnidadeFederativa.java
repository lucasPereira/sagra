package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaUnidadeFederativa {

	private Ambiente ambiente;
	private List<UnidadeFederativa> unidades;

	public PersistenciaUnidadeFederativa(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.unidades = new LinkedList<>();
	}

	public OperacaoDePersistencia<String> cadastrar(UnidadeFederativa unidade) {
		if (!unidades.contains(unidade)) {
			unidades.add(unidade);
			String identificador = ambiente.obterGeradorDeIdentificador().gerar();
			return new OperacaoDePersistencia<>(identificador);
		}
		return new OperacaoDePersistencia<>();
	}

}
