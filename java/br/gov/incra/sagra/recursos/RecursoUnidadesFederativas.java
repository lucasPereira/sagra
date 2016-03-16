package br.gov.incra.sagra.recursos;

import java.util.ArrayList;
import java.util.List;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;
import br.gov.incra.sagra.persistencia.Registro;

public class RecursoUnidadesFederativas {

	private Ambiente ambiente;

	public RecursoUnidadesFederativas(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Resposta<UnidadeFederativa> post(String nome, String sigla) {
		FabricaUnidadeFederativa fabrica = new FabricaUnidadeFederativa();
		fabrica.comNome(nome);
		fabrica.comSigla(sigla);
		if (!fabrica.validarDados()) {
			return new Resposta<UnidadeFederativa>(CodigoDeEstado.HTTP400);
		}
		UnidadeFederativa unidadeFederativa = fabrica.construir();
		OperacaoDePersistencia<String> operacao = ambiente.persistenciaUnidadeFederativa().cadastrar(unidadeFederativa);
		String uri = String.format("/unidadeFederativa/%s", operacao.obterResultado());
		return new Resposta<UnidadeFederativa>(CodigoDeEstado.HTTP201, uri, unidadeFederativa);
	}

	public Resposta<List<String>> get() {
		OperacaoDePersistencia<List<Registro<UnidadeFederativa>>> operacao = ambiente.persistenciaUnidadeFederativa().listar();
		List<String> unidadesFederativas = new ArrayList<>(operacao.obterResultado().size());
		operacao.obterResultado().forEach(registro -> unidadesFederativas.add(String.format("/unidadeFederativa/%s", registro.obterIdentificador())));
		return new Resposta<List<String>>(CodigoDeEstado.HTTP200, unidadesFederativas);
	}

}
