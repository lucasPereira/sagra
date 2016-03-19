package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.recursos.RepresentacaoEntidade;
import br.gov.incra.sagra.testes.auxiliar.TesteEntidade;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteEntidade.class)
public class TesteRepresentacaoEntidade {

	@Fixture private Entidade entidade1;
	@Fixture private Entidade entidade2;

	private RepresentacaoEntidade<Entidade> representacaoEntidade1;
	private RepresentacaoEntidade<Entidade> representacaoEntidade2;

	@Before
	public void configurar() {
		representacaoEntidade1 = new RepresentacaoEntidade<>("/recurso/1", entidade1);
		representacaoEntidade2 = new RepresentacaoEntidade<>("/recurso/2", entidade2);
	}

	@Test
	public void representacao1() throws Exception {
		assertEquals("/recurso/1", representacaoEntidade1.uri());
		assertEquals(entidade1, representacaoEntidade1.entidade());
	}

	@Test
	public void representacao2() throws Exception {
		assertEquals("/recurso/2", representacaoEntidade2.uri());
		assertEquals(entidade2, representacaoEntidade2.entidade());
	}

	@Test
	public void iguais() throws Exception {
		RepresentacaoEntidade<Entidade> representacao1Clone = new RepresentacaoEntidade<>("/recurso/1", entidade1);
		RepresentacaoEntidade<Entidade> representacao2Clone = new RepresentacaoEntidade<>("/recurso/2", entidade2);
		assertEquals(representacao1Clone, representacaoEntidade1);
		assertEquals(representacao2Clone, representacaoEntidade2);

	}

	@Test
	public void diferentes() throws Exception {
		RepresentacaoEntidade<Entidade> representacao12 = new RepresentacaoEntidade<>("/recurso/1", entidade2);
		RepresentacaoEntidade<Entidade> representacao21 = new RepresentacaoEntidade<>("/recurso/2", entidade1);
		assertNotEquals(representacao12, representacaoEntidade1);
		assertNotEquals(representacao12, representacaoEntidade2);
		assertNotEquals(representacao21, representacaoEntidade1);
		assertNotEquals(representacao21, representacaoEntidade2);
		assertNotEquals(representacaoEntidade1, representacaoEntidade2);
	}

}
