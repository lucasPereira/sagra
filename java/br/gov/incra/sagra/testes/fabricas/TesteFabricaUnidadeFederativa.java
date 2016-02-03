package br.gov.incra.sagra.testes.fabricas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.fabricas.FabricaUnidadeFederativa;
import br.gov.incra.sagra.testes.entidades.TesteSantaCatarina;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteSantaCatarina.class)
public class TesteFabricaUnidadeFederativa {

	@Fixture private UnidadeFederativa santaCatarina;

	private FabricaUnidadeFederativa fabrica;

	@Before
	public void configurar() {
		fabrica = new FabricaUnidadeFederativa();
	}

	@Test
	public void santaCatarina() throws Exception {
		fabrica.comNome("Santa Catarina");
		fabrica.comSigla("SC");
		assertTrue(fabrica.validarDados());
		assertEquals(santaCatarina, fabrica.construir());
	}

	@Test
	public void saoPaulo() throws Exception {
		fabrica.comNome("São Paulo");
		fabrica.comSigla("SP");
		assertTrue(fabrica.validarDados());
	}

	@Test
	public void siglaComUmCaractere() throws Exception {
		fabrica.comNome("Unidade Federativa");
		fabrica.comSigla("U");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void siglaComTresCaracteres() throws Exception {
		fabrica.comNome("Unidade Federativa");
		fabrica.comSigla("UFA");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void siglaComMinusculo() throws Exception {
		fabrica.comNome("Unidade Federativa");
		fabrica.comSigla("Uf");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void siglaComAcento() throws Exception {
		fabrica.comNome("Unidade Federativa");
		fabrica.comSigla("ÚF");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void siglaComNumero() throws Exception {
		fabrica.comNome("Unidade Federativa");
		fabrica.comSigla("U0");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeVazio() throws Exception {
		fabrica.comNome("");
		fabrica.comSigla("UF");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComNumero() throws Exception {
		fabrica.comNome("São Paulo 10");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComMultiplosEspacosNumero() throws Exception {
		fabrica.comNome("São  Paulo");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComEspacosNoInicio() throws Exception {
		fabrica.comNome(" São Paulo");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComEspacosNoFim() throws Exception {
		fabrica.comNome("São Paulo ");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComPonto() throws Exception {
		fabrica.comNome("São Paulo.");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void nomeComSimbolo() throws Exception {
		fabrica.comNome("Sംo Paulo");
		fabrica.comSigla("SP");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void apenasNome() throws Exception {
		fabrica.comNome("Unidade Federativa");
		assertFalse(fabrica.validarDados());
	}

	@Test
	public void apenasSigla() throws Exception {
		fabrica.comSigla("UF");
		assertFalse(fabrica.validarDados());
	}

}
