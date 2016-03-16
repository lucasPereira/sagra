package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaSuperintendenciaRegional {

	private Ambiente ambiente;
	private List<SuperintendenciaRegional> superintendencias;

	public PersistenciaSuperintendenciaRegional(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.superintendencias = new LinkedList<>();
	}

	public OperacaoDePersistencia<String> cadastrar(SuperintendenciaRegional superintendencia) {
		superintendencias.add(superintendencia);
		return new OperacaoDePersistencia<>(ambiente.auxiliarGeradorDeIdentificador().gerar());
	}

}
