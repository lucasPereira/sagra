package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.RecursoUnidadesFederativas;
import br.gov.incra.sagra.recursos.RepresentacaoColecao;
import br.gov.incra.sagra.recursos.RepresentacaoEntidade;
import br.gov.incra.sagra.recursos.RespostaRecurso;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaMatoGrosso;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaSantaCatarina;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteUnidadeFederativaSantaCatarina.class, TesteUnidadeFederativaMatoGrosso.class })
public class TesteRecursoUnidadesFederativas {

	@Fixture private Ambiente ambiente;
	@Fixture private UnidadeFederativa santaCatarina;
	@Fixture private UnidadeFederativa matoGrosso;

	private RecursoUnidadesFederativas recurso;

	@Before
	public void configurar() {
		recurso = ambiente.recursoUnidadesFederativas();
	}

	@Test
	public void postUm() throws Exception {
		RespostaRecurso<RepresentacaoEntidade<UnidadeFederativa>> resposta = recurso.post("Santa Catarina", "SC");
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals("/unidadeFederativa/1", resposta.representacao().uri());
		assertEquals(santaCatarina, resposta.representacao().entidade());
	}

	@Test
	public void postDois() throws Exception {
		recurso.post("Santa Catarina", "SC");
		RespostaRecurso<RepresentacaoEntidade<UnidadeFederativa>> resposta = recurso.post("Mato Grosso", "MT");
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals("/unidadeFederativa/2", resposta.representacao().uri());
		assertEquals(matoGrosso, resposta.representacao().entidade());
	}

	@Test
	public void postDoisIguais() throws Exception {
		recurso.post("Santa Catarina", "SC");
		RespostaRecurso<RepresentacaoEntidade<UnidadeFederativa>> resposta = recurso.post("Santa Catarina", "SC");
		assertEquals(CodigoDeEstado.HTTP201, resposta.codigoDeEstado());
		assertEquals("/unidadeFederativa/2", resposta.representacao().uri());
		assertEquals(santaCatarina, resposta.representacao().entidade());
	}

	@Test
	public void postUmInvalido() throws Exception {
		RespostaRecurso<RepresentacaoEntidade<UnidadeFederativa>> resposta = recurso.post("Santa Catarina", "");
		assertEquals(CodigoDeEstado.HTTP400, resposta.codigoDeEstado());
		assertNull(resposta.representacao());
	}

	@Test
	public void getComZero() throws Exception {
		RespostaRecurso<RepresentacaoColecao<UnidadeFederativa>> resposta = ambiente.recursoUnidadesFederativas().get();
		assertEquals(CodigoDeEstado.HTTP200, resposta.codigoDeEstado());
		assertEquals("/unidadesFederativas", resposta.representacao().uri());
		assertEquals(0, resposta.representacao().tamanho());
	}

	@Test
	public void getComDois() throws Exception {
		recurso.post("Santa Catarina", "SC");
		recurso.post("Mato Grosso", "MT");
		RespostaRecurso<RepresentacaoColecao<UnidadeFederativa>> resposta = ambiente.recursoUnidadesFederativas().get();
		assertEquals(CodigoDeEstado.HTTP200, resposta.codigoDeEstado());
		assertEquals("/unidadesFederativas", resposta.representacao().uri());
		assertEquals(2, resposta.representacao().tamanho());
		assertEquals("/unidadeFederativa/2", resposta.representacao().representacao(0).uri());
		assertEquals("/unidadeFederativa/1", resposta.representacao().representacao(1).uri());
		assertEquals(matoGrosso, resposta.representacao().representacao(0).entidade());
		assertEquals(santaCatarina, resposta.representacao().representacao(1).entidade());
	}

}
