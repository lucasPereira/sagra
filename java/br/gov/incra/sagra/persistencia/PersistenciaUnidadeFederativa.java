package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;

public class PersistenciaUnidadeFederativa {

	private List<UnidadeFederativa> unidadesFederativas;

	public PersistenciaUnidadeFederativa() {
		unidadesFederativas = new LinkedList<>();
	}

	public Boolean cadastrarUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		if (!unidadesFederativas.contains(unidadeFederativa)) {
			unidadesFederativas.add(unidadeFederativa);
			return true;
		}
		return false;
	}

}