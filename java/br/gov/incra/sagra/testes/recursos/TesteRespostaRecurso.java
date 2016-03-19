package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.RepresentacaoEntidade;
import br.gov.incra.sagra.recursos.RepresentacaoColecao;
import br.gov.incra.sagra.recursos.RespostaRecurso;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({TesteRepresentacaoEntidade.class, TesteRepresentacaoColecao.class})
public class TesteRespostaRecurso {

	@Fixture private RepresentacaoEntidade<?> representacaoEntidade1;
	@Fixture private RepresentacaoColecao<?> representacaoColecaoComDois;
	
	@Test
	public void semRepresentacao() throws Exception {
		RespostaRecurso<?> resposta = new RespostaRecurso<>(CodigoDeEstado.HTTP204);
		assertEquals(CodigoDeEstado.HTTP204, resposta.codigoDeEstado());
		assertNull(resposta.representacao());
	}

	@Test
	public void representacaoEntidade() throws Exception {
		RespostaRecurso<?> resposta = new RespostaRecurso<>(CodigoDeEstado.HTTP201, representacaoEntidade1);
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals(representacaoEntidade1, resposta.representacao());
	}

	@Test
	public void representacaoColetacao() throws Exception {
		RespostaRecurso<?> resposta = new RespostaRecurso<>(CodigoDeEstado.HTTP200, representacaoColecaoComDois);
		assertEquals(CodigoDeEstado.HTTP200, resposta.codigoDeEstado());
		assertEquals(representacaoColecaoComDois, resposta.representacao());
	}

}
