package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.recursos.Representacao;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteRepresentacao {

	@Fixture private Entidade entidade;

	@Test
	public void testar() throws Exception {
		Representacao<Entidade> representacao = new Representacao<>("/recurso/1", entidade);
		assertEquals("/recurso/1", representacao.uri());
		assertEquals(entidade, representacao.entidade());
	}

}
