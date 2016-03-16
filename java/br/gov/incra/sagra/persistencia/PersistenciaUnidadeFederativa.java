package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaUnidadeFederativa {

	private Ambiente ambiente;
	private List<Registro<UnidadeFederativa>> registros;

	public PersistenciaUnidadeFederativa(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.registros = new LinkedList<>();
	}

	public OperacaoDePersistencia<String> cadastrar(UnidadeFederativa entidade) {
		String identificador = ambiente.auxiliarGeradorDeIdentificador().gerar();
		Registro<UnidadeFederativa> registro = new Registro<>(identificador, entidade);
		registros.add(registro);
		return new OperacaoDePersistencia<>(identificador);
	}

	public OperacaoDePersistencia<List<Registro<UnidadeFederativa>>> listar() {
		return new OperacaoDePersistencia<>(registros);
	}

}
