package br.gov.incra.sagra.testes.recursos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.recursos.CodigoDeEstado;
import br.gov.incra.sagra.recursos.Resposta;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaMatoGrosso;
import br.gov.incra.sagra.testes.entidades.TesteUnidadeFederativaSantaCatarina;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteUnidadeFederativaSantaCatarina.class, TesteUnidadeFederativaMatoGrosso.class })
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

	@Test
	public void postSantaCatarinaRepetida() throws Exception {
		Resposta<UnidadeFederativa> respostaPostSantaCatarinaRepetido = ambiente.recursoUnidadesFederativas().post("Santa Catarina", "SC");
		assertEquals(CodigoDeEstado.HTTP201, respostaPostSantaCatarinaRepetido.codigoDeEstado());
		assertEquals("/unidadeFederativa/2", respostaPostSantaCatarinaRepetido.localizacao());
		assertEquals(santaCatarina, respostaPostSantaCatarinaRepetido.entidade());
	}

	@Test
	public void postSantaCatarinaInvalida() throws Exception {
		Resposta<UnidadeFederativa> respostaPostSantaCatarinaRepetido = ambiente.recursoUnidadesFederativas().post("Santa Catarina", "");
		assertEquals(CodigoDeEstado.HTTP400, respostaPostSantaCatarinaRepetido.codigoDeEstado());
		assertEquals(null, respostaPostSantaCatarinaRepetido.localizacao());
		assertEquals(null, respostaPostSantaCatarinaRepetido.entidade());
	}

	@Test
	public void get() throws Exception {
		Resposta<List<String>> respostaGet = ambiente.recursoUnidadesFederativas().get();
		assertEquals(CodigoDeEstado.HTTP200, respostaGet.codigoDeEstado());
		assertEquals(null, respostaGet.localizacao());
		assertEquals(1, respostaGet.entidade().size());
		assertEquals("/unidadeFederativa/1", respostaGet.entidade().get(0));
	}

}
