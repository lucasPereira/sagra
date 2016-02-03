package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.Resposta;
import br.gov.incra.sagra.testes.entidades.TesteMatoGrosso;
import br.gov.incra.sagra.testes.entidades.TesteSantaCatarina;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteSantaCatarina.class, TesteMatoGrosso.class })
public class TesteRecursoUnidadesFederativas {

	@Fixture Ambiente ambiente;
	@Fixture UnidadeFederativa santaCatarina;
	@Fixture UnidadeFederativa matoGrosso;

	private Resposta<UnidadeFederativa> respostaPostSantaCatarina;

	@Before
	public void configurar() {
		respostaPostSantaCatarina = ambiente.recursoUnidadesFederativas().post("Santa Catarina", "SC");
	}

	@Test
	public void postSantaCatarina() throws Exception {
		assertEquals(CodigoDeEstado.HTTP201, respostaPostSantaCatarina.codigoDeEstado());
		assertEquals("/unidadeFederativa/1", respostaPostSantaCatarina.localizacao());
		assertEquals(santaCatarina, respostaPostSantaCatarina.entidade());
	}

	@Test
	public void postMatoGrosso() throws Exception {
		Resposta<UnidadeFederativa> respostaPostMatoGrosso = ambiente.recursoUnidadesFederativas().post("Mato Grosso", "MT");
		assertEquals(CodigoDeEstado.HTTP201, respostaPostMatoGrosso.codigoDeEstado());
		assertEquals("/unidadeFederativa/2", respostaPostMatoGrosso.localizacao());
		assertEquals(matoGrosso, respostaPostMatoGrosso.entidade());
	}

}
