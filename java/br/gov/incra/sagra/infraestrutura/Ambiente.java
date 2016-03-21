package br.gov.incra.sagra.infraestrutura;

import br.gov.incra.sagra.auxiliar.GeradorDeIdentificador;
import br.gov.incra.sagra.auxiliar.GeradorDeIdentificadorInteiroSequencial;
import br.gov.incra.sagra.persistencia.BancoDeDocumentos;
import br.gov.incra.sagra.persistencia.MapeadorJson;
import br.gov.incra.sagra.persistencia.MapeadorJsonParaTestes;
import br.gov.incra.sagra.persistencia.PersistenciaSuperintendenciaRegional;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.recursos.RecursoUnidadesFederativas;

public class Ambiente {

	private GeradorDeIdentificador geradorDeIdentificador;
	private PersistenciaUnidadeFederativa persistenciaUnidadeFederativa;
	private PersistenciaSuperintendenciaRegional persistenciaSuperintendenciaRegional;
	private RecursoUnidadesFederativas recursoUnidadesFederativas;

	public Ambiente() {
		this.geradorDeIdentificador = new GeradorDeIdentificadorInteiroSequencial();
		this.persistenciaUnidadeFederativa = new PersistenciaUnidadeFederativa(this);
		this.persistenciaSuperintendenciaRegional = new PersistenciaSuperintendenciaRegional(this);
		this.recursoUnidadesFederativas = new RecursoUnidadesFederativas(this);
	}

	public GeradorDeIdentificador geradorDeIdentificador() {
		return geradorDeIdentificador;
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

	public MapeadorJson mapeadorJson() {
		return new MapeadorJsonParaTestes(this);
	}

	public BancoDeDocumentos bancoDeDocumentos() {
		return new BancoDeDocumentos(this);
	}

}
