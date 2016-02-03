package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaSuperintendenciaRegional {

	private Ambiente ambienteDeTeste;
	private List<SuperintendenciaRegional> superintendencias;

	public PersistenciaSuperintendenciaRegional(Ambiente ambienteDeTeste) {
		this.ambienteDeTeste = ambienteDeTeste;
		this.superintendencias = new LinkedList<>();
	}

	public OperacaoDePersistencia<String> cadastrar(SuperintendenciaRegional superintendencia) {
		if (!superintendencias.contains(superintendencia)) {
			superintendencias.add(superintendencia);
			String identificador = ambienteDeTeste.obterGeradorDeIdentificador().gerar();
			return new OperacaoDePersistencia<>(identificador);
		}
		return new OperacaoDePersistencia<>();
	}

}
