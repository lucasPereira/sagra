package br.gov.incra.sagra.recursos;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.RespostaPersistencia;

public class RecursoUnidadesFederativas {

	private Ambiente ambiente;

	public RecursoUnidadesFederativas(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public RespostaRecurso<UnidadeFederativa> post(String nome, String sigla) {
		FabricaUnidadeFederativa fabrica = new FabricaUnidadeFederativa();
		fabrica.comNome(nome);
		fabrica.comSigla(sigla);
		if (!fabrica.validarDados()) {
			return new RespostaRecurso<UnidadeFederativa>(CodigoDeEstado.HTTP400);
		}
		RespostaPersistencia<UnidadeFederativa> persistencia = ambiente.persistenciaUnidadeFederativa().cadastrar(fabrica.construir());
		String uri = String.format("/unidadeFederativa/%s", persistencia.documento().identificador());
		return new RespostaRecurso<UnidadeFederativa>(CodigoDeEstado.HTTP201, uri, persistencia.documento().entidade());
	}

}
