package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.recursos.RepresentacaoEntidade;
import br.gov.incra.sagra.recursos.RepresentacaoColecao;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteRepresentacaoEntidade.class)
public class TesteRepresentacaoColecao {

	@Fixture private RepresentacaoEntidade<Entidade> representacaoEntidade1;
	@Fixture private RepresentacaoEntidade<Entidade> representacaoEntidade2;

	private RepresentacaoColecao<Entidade> representacaoColecaoComZero;
	private RepresentacaoColecao<Entidade> representacaoColecaoComDois;

	@Before
	public void configurar() {
		representacaoColecaoComZero = new RepresentacaoColecao<>("/recursos", Arrays.asList());
		representacaoColecaoComDois = new RepresentacaoColecao<>("/recursos", Arrays.asList(representacaoEntidade1, representacaoEntidade2));
		assertNotNull(representacaoEntidade1);
		assertNotNull(representacaoEntidade2);
	}

	@Test
	public void representacaoColecaoComNenhum() throws Exception {
		assertEquals("/recursos", representacaoColecaoComZero.uri());
		assertEquals(0, representacaoColecaoComZero.tamanho());
	}

	@Test
	public void representacaoColecaoComDois() throws Exception {
		assertEquals("/recursos", representacaoColecaoComDois.uri());
		assertEquals(2, representacaoColecaoComDois.tamanho());
		assertEquals(representacaoEntidade1, representacaoColecaoComDois.representacao(0));
		assertEquals(representacaoEntidade2, representacaoColecaoComDois.representacao(1));
	}

	@Test
	public void iguais() throws Exception {
		RepresentacaoColecao<Entidade> representacaoComZeroClone = new RepresentacaoColecao<>("/recursos", Arrays.asList());
		RepresentacaoColecao<Entidade> representacaoComDoisClone = new RepresentacaoColecao<>("/recursos", Arrays.asList(representacaoEntidade1, representacaoEntidade2));
		assertEquals(representacaoComZeroClone, representacaoColecaoComZero);
		assertEquals(representacaoComDoisClone, representacaoColecaoComDois);

	}

	@Test
	public void diferentes() throws Exception {
		RepresentacaoColecao<Entidade> representacaoComDoisUriDiferente = new RepresentacaoColecao<>("/resources", Arrays.asList(representacaoEntidade1, representacaoEntidade2));
		RepresentacaoColecao<Entidade> representacaoComDoisInvertida = new RepresentacaoColecao<>("/recursos", Arrays.asList(representacaoEntidade2, representacaoEntidade1));
		assertNotEquals(representacaoComDoisUriDiferente, representacaoColecaoComDois);
		assertNotEquals(representacaoComDoisInvertida, representacaoColecaoComDois);
	}

}
