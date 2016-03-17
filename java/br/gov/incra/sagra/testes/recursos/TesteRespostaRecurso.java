package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.RespostaRecurso;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteRespostaRecurso {

	@Fixture private Entidade entidade;

	@Test
	public void comEntidade() throws Exception {
		RespostaRecurso<?> resposta = new RespostaRecurso<>(CodigoDeEstado.HTTP201, "/recurso/1", entidade);
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals("/recurso/1", resposta.representacao().uri());
		assertEquals(entidade, resposta.representacao().entidade());
	}

	@Test
	public void semEntidade() throws Exception {
		RespostaRecurso<?> resposta = new RespostaRecurso<>(CodigoDeEstado.HTTP204);
		assertEquals(CodigoDeEstado.HTTP204, resposta.codigoDeEstado());
		assertNull(resposta.representacao());
	}

}
