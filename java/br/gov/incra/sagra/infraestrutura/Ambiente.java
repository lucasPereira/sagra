package br.gov.incra.sagra.infraestrutura;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;
import br.gov.incra.sagra.auxiliar.GeradorDeIdentificadorInteiroSequencial;
import br.gov.incra.sagra.persistencia.PersistenciaSuperintendenciaRegional;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.recursos.RecursoUnidadesFederativas;

public class Ambiente {

	private GeradorDeIdentificador auxiliarGerador;
	private PersistenciaUnidadeFederativa persistenciaUnidadeFederativa;
	private PersistenciaSuperintendenciaRegional persistenciaSuperintendenciaRegional;
	private RecursoUnidadesFederativas recursoUnidadesFederativas;

	public Ambiente() {
		this.auxiliarGerador = new GeradorDeIdentificadorInteiroSequencial();
		this.persistenciaUnidadeFederativa = new PersistenciaUnidadeFederativa(this);
		this.persistenciaSuperintendenciaRegional = new PersistenciaSuperintendenciaRegional(this);
		this.recursoUnidadesFederativas = new RecursoUnidadesFederativas(this);
	}

	public void iniciarPersistencia() {
		try {
			Unirest.delete(persistenciaNome()).asBinary();
			Unirest.put(persistenciaNome()).asBinary();
		} catch (UnirestException excecao) {
			excecao.printStackTrace();
		}
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

	public RecursoUnidadesFederativas recursoUnidadesFederativas() {
		return recursoUnidadesFederativas;
	}

	public String persistenciaNome() {
		return "http://localhost:5984/sagra";
	}

}
