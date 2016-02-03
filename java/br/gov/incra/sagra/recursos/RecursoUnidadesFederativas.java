package br.gov.incra.sagra.recursos;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.OperacaoDePersistencia;

public class RecursoUnidadesFederativas {

	private Ambiente ambiente;

	public RecursoUnidadesFederativas(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Resposta<UnidadeFederativa> post(String nome, String sigla) {
		FabricaUnidadeFederativa fabrica = new FabricaUnidadeFederativa();
		fabrica.comNome(nome);
		fabrica.comSigla(sigla);
		UnidadeFederativa unidadeFederativa = fabrica.construir();
		OperacaoDePersistencia<String> operacao = ambiente.persistenciaUnidadeFederativa().cadastrar(unidadeFederativa);
		String uri = String.format("/unidadeFederativa/%s", operacao.obterValor());
		return new Resposta<UnidadeFederativa>(CodigoDeEstado.HTTP201, uri, unidadeFederativa);
	}

}
