package br.gov.incra.sagra.infraestrutura;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;
import br.gov.incra.sagra.auxiliar.GeradorDeIdentificadorInteiroSequencial;
import br.gov.incra.sagra.persistencia.PersistenciaSuperintendenciaRegional;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;

public class Ambiente {

	private GeradorDeIdentificador auxiliarGerador;
	private PersistenciaUnidadeFederativa persistenciaUnidadeFederativa;
	private PersistenciaSuperintendenciaRegional persistenciaSuperintendenciaRegional;

	public Ambiente() {
		this.auxiliarGerador = new GeradorDeIdentificadorInteiroSequencial();
		this.persistenciaUnidadeFederativa = new PersistenciaUnidadeFederativa(this);
		this.persistenciaSuperintendenciaRegional = new PersistenciaSuperintendenciaRegional(this);
	}

	public GeradorDeIdentificador auxiliarGeradorDeIdentificador() {
		return auxiliarGerador;
	}

	public PersistenciaSuperintendenciaRegional persistenciaSuperintendenciaRegional() {
		return persistenciaSuperintendenciaRegional;
	}

	public PersistenciaUnidadeFederativa persistenciaUnidadeFederativa() {
		return persistenciaUnidadeFederativa;
	}

}
